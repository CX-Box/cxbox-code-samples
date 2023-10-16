package org.demo.documentation.text.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample40Service extends VersionAwareResponseService<MyExample40DTO, MyEntity40> {

	private final MyEntity40Repository repository;

	public MyExample40Service(MyEntity40Repository repository) {
		super(MyExample40DTO.class, MyEntity40.class, null, MyExample40Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample40DTO> doCreateEntity(MyEntity40 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample40DTO> doUpdateEntity(MyEntity40 entity, MyExample40DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(org.demo.documentation.text.basic.MyExample40DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample40DTO> getActions() {
		return Actions.<MyExample40DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}