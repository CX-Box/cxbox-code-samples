package org.demo.documentation.other.savewithparent.example5.service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDTO;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDTO_;
import org.demo.documentation.other.savewithparent.example5.entity.ApplicationEntity;
import org.demo.documentation.other.savewithparent.example5.entity.Executor;
import org.demo.documentation.other.savewithparent.example5.entity.Task;
import org.demo.documentation.other.savewithparent.example5.meta.TaskMeta;
import org.demo.documentation.other.savewithparent.example5.repositories.ApplicationRepository;
import org.demo.documentation.other.savewithparent.example5.repositories.ExecutorRepository;
import org.demo.documentation.other.savewithparent.example5.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class MyExample5555TaskService extends VersionAwareResponseService<TaskDTO, Task> {

	private static final String EXECUTOR = "/screen/autosave/view/executor";

	public static final String LINK_TASK_DOCUMENT = "/screen/autosave/view/taskDocument";

	public static final String NEXT = "Next";

	private final TaskRepository repository;

	private final ApplicationRepository applicationRepository;

	private final ExecutorRepository executorRepository;

	public MyExample5555TaskService(TaskRepository repository,
			ApplicationRepository applicationRepository,
			ExecutorRepository executorRepository) {
		super(TaskDTO.class, Task.class, null, TaskMeta.class);
		this.repository = repository;
		this.applicationRepository = applicationRepository;
		this.executorRepository = executorRepository;
	}

	@Override
	protected CreateResult<TaskDTO> doCreateEntity(Task entity, BusinessComponent bc) {
		ApplicationEntity application = applicationRepository.getById(bc.getParentIdAsLong());
		entity.setApplicationEntityId(application);
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<TaskDTO> doUpdateEntity(Task entity, TaskDTO data, BusinessComponent bc) {
		setIfChanged(data, TaskDTO_.name, entity::setName);
		setIfChanged(data, TaskDTO_.status, entity::setStatus);
		setIfChanged(data, TaskDTO_.comment, entity::setComment);
		setIfChanged(data, TaskDTO_.file, entity::setFile);
		setIfChanged(data, TaskDTO_.importance, entity::setImportance);

		if (data.isFieldChanged(TaskDTO_.executorId)) {
			Executor executor = executorRepository.getById(Long.valueOf(data.getExecutorId()));
			entity.setExecutorId(executor);
		}

		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<TaskDTO> getActions() {
		return Actions.<TaskDTO>builder()
				.create().text("Add").add()
				.save().add()
				.action("nextTaskDocument", NEXT)
				.invoker((bc, dto) ->
						new ActionResultDTO<TaskDTO>().setAction(
								PostAction.drillDown(
										DrillDownType.INNER,
										LINK_TASK_DOCUMENT
								))
				)
				.scope(ActionScope.BC)
				.withoutAutoSaveBefore()
				.add()
				.action("nextExecutor", NEXT)
				.invoker((bc, dto) ->
						new ActionResultDTO<TaskDTO>().setAction(
								PostAction.drillDown(
										DrillDownType.INNER,
										EXECUTOR
								))
				)
				.scope(ActionScope.BC)
				.withoutAutoSaveBefore()
				.add()
				.build();

	}

}
