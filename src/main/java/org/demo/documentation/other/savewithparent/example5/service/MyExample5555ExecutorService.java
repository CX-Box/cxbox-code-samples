package org.demo.documentation.other.savewithparent.example5.service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.savewithparent.example5.CxboxMyExample5555Controller;
import org.demo.documentation.other.savewithparent.example5.dto.ExecutorDTO;
import org.demo.documentation.other.savewithparent.example5.dto.ExecutorDTO_;
import org.demo.documentation.other.savewithparent.example5.entity.Executor;
import org.demo.documentation.other.savewithparent.example5.meta.ExecutorMeta;
import org.demo.documentation.other.savewithparent.example5.repositories.ExecutorRepository;
import org.springframework.stereotype.Service;

@Service
public class MyExample5555ExecutorService extends VersionAwareResponseService<ExecutorDTO, Executor> {

	private static final String SUB_INFO = "/screen/autosave/view/sumInfo";

	private static final String EXECUTOR_EDIT = "/screen/autosave/view/executorEdit/";

	private static final String EXECUTOR = "/screen/autosave/view/executor";

	public static final String NEXT = "Next";

	private final ExecutorRepository repository;

	public MyExample5555ExecutorService(ExecutorRepository repository) {
		super(ExecutorDTO.class, Executor.class, null, ExecutorMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<ExecutorDTO> doCreateEntity(Executor entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity))
				.setAction(PostAction.drillDown(
						DrillDownType.INNER,
						EXECUTOR_EDIT
								+ CxboxMyExample5555Controller.executor + "/"
								+ entity.getId()
				));
	}

	@Override
	protected ActionResultDTO<ExecutorDTO> doUpdateEntity(Executor entity, ExecutorDTO data, BusinessComponent bc) {
		setIfChanged(data, ExecutorDTO_.name, entity::setName);
		setIfChanged(data, ExecutorDTO_.role, entity::setRole);
		repository.save(entity);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<ExecutorDTO> getActions() {
		return Actions.<ExecutorDTO>builder()
				.create().text("Add").add()
				.action("finish", "Save")
				.invoker((bc, dto) -> {
					Executor executor = repository.getById(bc.getIdAsLong());
					repository.save(executor);
					return new ActionResultDTO<ExecutorDTO>().setAction(
							PostAction.drillDown(
									DrillDownType.INNER,
									EXECUTOR
							));
				})
				.add()
				.action("nextSubInfo", NEXT)
				.invoker((bc, dto) ->
						new ActionResultDTO<ExecutorDTO>().setAction(
								PostAction.drillDown(
										DrillDownType.INNER,
										SUB_INFO
								))
				)
				.scope(ActionScope.BC)
				.withoutAutoSaveBefore()
				.add()
				.save().text("Save").scope(ActionScope.BC)
				.add()
				.delete().text("Delete")
				.add()
				.cancelCreate()
				.text("Cancel")
				.scope(ActionScope.BC)
				.add()
				.build();
	}

}
