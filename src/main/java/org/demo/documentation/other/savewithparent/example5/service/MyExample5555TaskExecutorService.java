package org.demo.documentation.other.savewithparent.example5.service;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.ActionScope;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.savewithparent.example5.dto.ExecutorDTO;
import org.demo.documentation.other.savewithparent.example5.dto.ExecutorDTO_;
import org.demo.documentation.other.savewithparent.example5.entity.Executor;
import org.demo.documentation.other.savewithparent.example5.repositories.ExecutorRepository;
import org.springframework.stereotype.Service;

@Service
public class MyExample5555TaskExecutorService extends VersionAwareResponseService<ExecutorDTO, Executor> {

	private final ExecutorRepository repository;

	public MyExample5555TaskExecutorService(ExecutorRepository repository) {
		super(ExecutorDTO.class, Executor.class, null, MyExample5555TaskExecutorMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<ExecutorDTO> doCreateEntity(Executor entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
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
				.create(crt -> crt.text("Add").scope(ActionScope.BC))
				.delete(del -> del.text("Delete").scope(ActionScope.BC))
				.save(save -> save.text("Save").scope(ActionScope.BC))
				.action(act -> act
						.action("nextExecutor", "Next")
						.invoker((bc, dto) ->
								new ActionResultDTO<ExecutorDTO>().setAction(
										PostAction.drillDown(
												DrillDownType.INNER,
												"/screen/autosave/view/executor"
										))
						)
						.scope(ActionScope.BC)
						.withoutAutoSaveBefore())
				.build();

	}


}
