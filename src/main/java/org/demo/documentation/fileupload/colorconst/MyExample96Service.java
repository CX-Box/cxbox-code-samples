package org.demo.documentation.fileupload.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample96Service extends VersionAwareResponseService<MyExample96DTO, MyEntity96> {

	private final MyEntity96Repository repository;

	public MyExample96Service(MyEntity96Repository repository) {
		super(MyExample96DTO.class, MyEntity96.class, null, MyExample96Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample96DTO> doCreateEntity(MyEntity96 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample96DTO> doUpdateEntity(MyEntity96 entity, MyExample96DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample96DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample96DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample96DTO> getActions() {
		return Actions.<MyExample96DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}