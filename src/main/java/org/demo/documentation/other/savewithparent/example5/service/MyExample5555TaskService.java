package org.demo.documentation.other.savewithparent.example5.service;

import lombok.NonNull;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.cxbox.meta.ui.field.WidgetName;
import org.cxbox.model.core.entity.BaseEntity_;
import org.demo.conf.cxbox.extention.action.ActionsExt;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDTO;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDTO_;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.demo.documentation.other.savewithparent.example5.entity.Executor;
import org.demo.documentation.other.savewithparent.example5.entity.Task;
import org.demo.documentation.other.savewithparent.example5.entity.Task_;
import org.demo.documentation.other.savewithparent.example5.repositories.ApplicationRepository;
import org.demo.documentation.other.savewithparent.example5.repositories.ExecutorRepository;
import org.demo.documentation.other.savewithparent.example5.repositories.TaskRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class MyExample5555TaskService extends VersionAwareResponseService<TaskDTO, Task> {

	private final TaskRepository repository;

	private final ApplicationRepository applicationRepository;

	private final ExecutorRepository executorRepository;

	public MyExample5555TaskService(TaskRepository repository,
			ApplicationRepository applicationRepository,
			ExecutorRepository executorRepository) {
		super(TaskDTO.class, Task.class, null, MyExample5555TaskMeta.class);
		this.repository = repository;
		this.applicationRepository = applicationRepository;
		this.executorRepository = executorRepository;
	}

	@Override
	protected Specification<Task> getParentSpecification(BusinessComponent bc) {
		return (root, cq, cb) -> cb.and(
				super.getParentSpecification(bc).toPredicate(root, cq, cb),
				cb.equal(root.get(Task_.applicationEntityId).get(BaseEntity_.id), bc.getParentIdAsLong())
		);

	}

	@Override
	protected CreateResult<TaskDTO> doCreateEntity(Task entity, BusinessComponent bc) {
		ApplicationEntity application = applicationRepository.getReferenceById(bc.getParentIdAsLong());
		entity.setApplicationEntityId(application);
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<TaskDTO> doUpdateEntity(Task entity, TaskDTO data, BusinessComponent bc) {
		setIfChanged(data, TaskDTO_.name, entity::setName);
		setIfChanged(data, TaskDTO_.status, entity::setStatus);
		setIfChanged(data, TaskDTO_.comment, entity::setComment);
		setIfChanged(data, TaskDTO_.importance, entity::setImportance);
		if (data.isFieldChanged(TaskDTO_.executorId)) {
			Executor executor = executorRepository.getReferenceById(Long.valueOf(data.getExecutorId()));
			entity.setExecutorId(executor);
		}
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<TaskDTO> getActions() {
		return Actions.<TaskDTO>builder()
				.save(sv -> sv.text("Save"))
				.create(crt -> crt.text("Add"))
				.action(act -> act
						.action("nextTaskDocument", "Next")
						.invoker((bc, dto) ->
								new ActionResultDTO<TaskDTO>().setAction(
										PostAction.drillDown(
												DrillDownType.INNER,
												"/screen/autosave/view/taskDocument"
										))
						)
						.scope(ActionScope.BC)
						.withoutAutoSaveBefore()
				)
				.action(act -> act
						.action("nextExecutor", "Next")
						.invoker((bc, dto) ->
								new ActionResultDTO<TaskDTO>().setAction(
										PostAction.drillDown(
												DrillDownType.INNER,
												"/screen/autosave/view/executor"
										))
						)
						.scope(ActionScope.BC)
						.withoutAutoSaveBefore()
				)
				.delete(dlt -> dlt.text("Delete")
				)
				.action(act -> act
						.action("save-send-application", "Save and send on approval")
						.withPreAction(confirmWithComment("Save and send on approval", "taskApprovalFormPopup"))
						.invoker((bc, data) -> withApproval()))
				.action(act -> act
						.action("save-send-task", "Save and send on approval")
						.withPreAction(confirmWithComment("Save and send on approval", "taskFormPopup"))
						.invoker((bc, data) -> withApproval())
				)
				.build();


	}

	private static PreAction confirmWithComment(@NonNull String actionText, @WidgetName @NonNull String widget) {
		return ActionsExt.confirmWithCustomWidget(actionText, widget, "Done", "Cancel");
	}

	private ActionResultDTO<TaskDTO> withApproval() {
		return new ActionResultDTO<>();
	}

}
