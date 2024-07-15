package org.demo.documentation.fields.checkbox.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample52Service extends VersionAwareResponseService<MyExample52DTO, MyEntity52> {

	private final MyEntity52Repository repository;

	public MyExample52Service(MyEntity52Repository repository) {
		super(MyExample52DTO.class, MyEntity52.class, null, MyExample52Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample52DTO> doCreateEntity(MyEntity52 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample52DTO> doUpdateEntity(MyEntity52 entity, MyExample52DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample52DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		if (data.isFieldChanged(MyExample52DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample52DTO> getActions() {
		return Actions.<MyExample52DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}