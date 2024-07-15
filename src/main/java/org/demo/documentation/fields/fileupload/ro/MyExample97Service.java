package org.demo.documentation.fields.fileupload.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample97Service extends VersionAwareResponseService<MyExample97DTO, MyEntity97> {

	private final MyEntity97Repository repository;

	public MyExample97Service(MyEntity97Repository repository) {
		super(MyExample97DTO.class, MyEntity97.class, null, MyExample97Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample97DTO> doCreateEntity(MyEntity97 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample97DTO> doUpdateEntity(MyEntity97 entity, MyExample97DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample97DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample97DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample97DTO> getActions() {
		return Actions.<MyExample97DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}