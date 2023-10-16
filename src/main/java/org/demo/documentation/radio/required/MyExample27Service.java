package org.demo.documentation.radio.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample27Service extends VersionAwareResponseService<MyExample27DTO, MyEntity27> {

	private final MyEntity27Repository repository;

	public MyExample27Service(MyEntity27Repository repository) {
		super(MyExample27DTO.class, MyEntity27.class, null, MyExample27Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample27DTO> doCreateEntity(MyEntity27 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample27DTO> doUpdateEntity(MyEntity27 entity, MyExample27DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample27DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample27DTO> getActions() {
		return Actions.<MyExample27DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}