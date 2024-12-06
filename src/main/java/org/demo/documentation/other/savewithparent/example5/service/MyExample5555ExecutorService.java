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
import org.demo.documentation.other.savewithparent.example5.repositories.ExecutorRepository;
import org.springframework.stereotype.Service;

@Service
public class MyExample5555ExecutorService extends VersionAwareResponseService<ExecutorDTO, Executor> {

	private final ExecutorRepository repository;

	public MyExample5555ExecutorService(ExecutorRepository repository) {
		super(ExecutorDTO.class, Executor.class, null, MyExample5555ExecutorMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<ExecutorDTO> doCreateEntity(Executor entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity))
				.setAction(PostAction.drillDown(
						DrillDownType.INNER,
						"/screen/autosave/view/executorEdit/"
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
				.create(crt -> crt.text("Add"))
				.action(act -> act
						.action("finish", "Save")
						.invoker((bc, dto) -> {
							Executor executor = repository.getReferenceById(bc.getIdAsLong());
							repository.save(executor);
							return new ActionResultDTO<ExecutorDTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/autosave/view/executor"
									));
						})
				)
				.save(sv -> sv.text("Save").scope(ActionScope.BC))
				.action(act -> act
						.action("nextSubInfo", "Next")
						.invoker((bc, dto) ->
								new ActionResultDTO<ExecutorDTO>().setAction(
										PostAction.drillDown(
												DrillDownType.INNER,
												"/screen/autosave/view/sumInfo"
										))
						)
						.scope(ActionScope.BC)
						.withoutAutoSaveBefore()
				)
				.delete(dlt -> dlt.text("Delete"))
				.cancelCreate(ccr -> ccr.text("Cancel").scope(ActionScope.BC))
				.build();
	}

}
