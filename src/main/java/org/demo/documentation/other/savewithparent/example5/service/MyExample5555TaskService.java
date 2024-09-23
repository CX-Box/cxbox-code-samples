package org.demo.documentation.other.savewithparent.example5.service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.service.action.ActionsBuilder;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDTO;
import org.demo.documentation.other.savewithparent.example5.dto.TaskDTO_;
import org.demo.documentation.other.savewithparent.example5.entity.Task;
import org.demo.documentation.other.savewithparent.example5.meta.TaskMeta;
import org.demo.documentation.other.savewithparent.example5.repositories.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class MyExample5555TaskService extends VersionAwareResponseService<TaskDTO, Task> {

	public static final String LINK_TASK_DOCUMENT = "/screen/autosave/view/taskDocument";
	public static final String NEXT = "Next";
	private final TaskRepository repository;

	public MyExample5555TaskService(TaskRepository repository) {
		super(TaskDTO.class, Task.class, null, TaskMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<TaskDTO> doCreateEntity(Task entity, BusinessComponent bc) {
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
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<TaskDTO> getActions() {
		ActionsBuilder<TaskDTO> builder = Actions.<TaskDTO>builder();
		builder.action("save", "Add");

		builder.create()
				.text("cancel")
				.withAutoSaveBefore();

		builder.delete()
				.text("cancel");

		builder.cancelCreate()
				.withAutoSaveBefore();

		builder.action("nextTaskDocument", NEXT)
				.invoker((bc, dto) ->
					new ActionResultDTO<TaskDTO>().setAction(
							PostAction.drillDown(
									DrillDownType.INNER,
									LINK_TASK_DOCUMENT
							))
				)
				.scope(ActionScope.BC)
				.withoutAutoSaveBefore();

		return builder.build();
	}
}
