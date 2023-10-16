package org.demo.documentation.money.nullable;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample307Service extends VersionAwareResponseService<MyExample307DTO, MyEntity307> {

	private final MyEntity307Repository repository;

	public MyExample307Service(MyEntity307Repository repository) {
		super(MyExample307DTO.class, MyEntity307.class, null, MyExample307Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample307DTO> doCreateEntity(MyEntity307 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample307DTO> doUpdateEntity(MyEntity307 entity, MyExample307DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample307DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample307DTO> getActions() {
		return Actions.<MyExample307DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}