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
import org.demo.documentation.other.savewithparent.example5.dto.ExecutorDTO;
import org.demo.documentation.other.savewithparent.example5.dto.ExecutorDTO_;
import org.demo.documentation.other.savewithparent.example5.entity.Executor;
import org.demo.documentation.other.savewithparent.example5.meta.ExecutorMeta;
import org.demo.documentation.other.savewithparent.example5.repositories.ExecutorRepository;
import org.springframework.stereotype.Service;

@Service
public class MyExample5555ExecutorService extends VersionAwareResponseService<ExecutorDTO, Executor> {

	private static final String SUB_INFO = "/screen/autosave/view/sumInfo";

	public static final String NEXT = "Next";

	private final ExecutorRepository repository;

	public MyExample5555ExecutorService(ExecutorRepository repository) {
		super(ExecutorDTO.class, Executor.class, null, ExecutorMeta.class);
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
		ActionsBuilder<ExecutorDTO> builder = Actions.builder();
		builder.create().text("Add").add();

		builder.save().text("Save").add();

		builder.action("nextSubInfo", NEXT)
				.invoker((bc, dto) ->
						new ActionResultDTO<ExecutorDTO>().setAction(
								PostAction.drillDown(
										DrillDownType.INNER,
										SUB_INFO
								))
				)
				.scope(ActionScope.BC)
				.withoutAutoSaveBefore()
				.add();

		return builder.build();
	}


}
