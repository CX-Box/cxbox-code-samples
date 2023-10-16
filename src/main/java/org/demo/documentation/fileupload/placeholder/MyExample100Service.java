package org.demo.documentation.fileupload.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample100Service extends VersionAwareResponseService<MyExample100DTO, MyEntity100> {

	private final MyEntity100Repository repository;

	public MyExample100Service(MyEntity100Repository repository) {
		super(MyExample100DTO.class, MyEntity100.class, null, MyExample100Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample100DTO> doCreateEntity(MyEntity100 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample100DTO> doUpdateEntity(MyEntity100 entity, MyExample100DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample100DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample100DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample100DTO> getActions() {
		return Actions.<MyExample100DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}