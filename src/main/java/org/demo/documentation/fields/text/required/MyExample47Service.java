package org.demo.documentation.fields.text.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample47Service extends VersionAwareResponseService<MyExample47DTO, MyEntity47> {

	private final MyEntity47Repository repository;

	public MyExample47Service(MyEntity47Repository repository) {
		super(MyExample47DTO.class, MyEntity47.class, null, MyExample47Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample47DTO> doCreateEntity(MyEntity47 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample47DTO> doUpdateEntity(MyEntity47 entity, MyExample47DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample47DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample47DTO> getActions() {
		return Actions.<MyExample47DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}