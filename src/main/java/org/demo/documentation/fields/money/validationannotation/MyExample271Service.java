package org.demo.documentation.fields.money.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample271Service extends VersionAwareResponseService<MyExample271DTO, MyEntity271> {

	private final MyEntity271Repository repository;

	public MyExample271Service(MyEntity271Repository repository) {
		super(MyExample271DTO.class, MyEntity271.class, null, MyExample271Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample271DTO> doCreateEntity(MyEntity271 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample271DTO> doUpdateEntity(MyEntity271 entity, MyExample271DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample271DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample271DTO> getActions() {
		return Actions.<MyExample271DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}