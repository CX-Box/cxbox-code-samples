package org.demo.documentation.checkbox.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample74Service extends VersionAwareResponseService<MyExample74DTO, MyEntity74> {

	private final MyEntity74Repository repository;

	public MyExample74Service(MyEntity74Repository repository) {
		super(MyExample74DTO.class, MyEntity74.class, null, MyExample74Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample74DTO> doCreateEntity(MyEntity74 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample74DTO> doUpdateEntity(MyEntity74 entity, MyExample74DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample74DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample74DTO> getActions() {
		return Actions.<MyExample74DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}