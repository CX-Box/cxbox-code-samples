package org.demo.documentation.fields.percent.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample7Service extends VersionAwareResponseService<MyExample7DTO, MyEntity7> {

	private final MyEntity7Repository repository;

	public MyExample7Service(MyEntity7Repository repository) {
		super(MyExample7DTO.class, MyEntity7.class, null, MyExample7Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample7DTO> doCreateEntity(MyEntity7 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample7DTO> doUpdateEntity(MyEntity7 entity, MyExample7DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample7DTO> getActions() {
		return Actions.<MyExample7DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}