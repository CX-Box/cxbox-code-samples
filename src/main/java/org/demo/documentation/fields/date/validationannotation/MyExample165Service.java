package org.demo.documentation.fields.date.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample165Service extends VersionAwareResponseService<MyExample165DTO, MyEntity165> {

	private final MyEntity165Repository repository;

	public MyExample165Service(MyEntity165Repository repository) {
		super(MyExample165DTO.class, MyEntity165.class, null, MyExample165Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample165DTO> doCreateEntity(MyEntity165 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample165DTO> doUpdateEntity(MyEntity165 entity, MyExample165DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample165DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample165DTO> getActions() {
		return Actions.<MyExample165DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}