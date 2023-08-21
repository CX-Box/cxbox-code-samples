package org.demo.documentation.fileupload.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample94Service extends VersionAwareResponseService<MyExample94DTO, MyEntity94> {

	private final MyEntity94Repository repository;

	public MyExample94Service(MyEntity94Repository repository) {
		super(MyExample94DTO.class, MyEntity94.class, null, MyExample94Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample94DTO> doCreateEntity(MyEntity94 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample94DTO> doUpdateEntity(MyEntity94 entity, MyExample94DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample94DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample94DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample94DTO> getActions() {
		return Actions.<MyExample94DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}