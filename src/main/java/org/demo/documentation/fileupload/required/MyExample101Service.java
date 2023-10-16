package org.demo.documentation.fileupload.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample101Service extends VersionAwareResponseService<MyExample101DTO, MyEntity101> {

	private final MyEntity101Repository repository;

	public MyExample101Service(MyEntity101Repository repository) {
		super(MyExample101DTO.class, MyEntity101.class, null, MyExample101Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample101DTO> doCreateEntity(MyEntity101 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample101DTO> doUpdateEntity(MyEntity101 entity, MyExample101DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample101DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample101DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample101DTO> getActions() {
		return Actions.<MyExample101DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}