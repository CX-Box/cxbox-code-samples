package org.demo.documentation.fileupload.validationbusinessex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample103Service extends VersionAwareResponseService<MyExample103DTO, MyEntity103> {

	private final MyEntity103Repository repository;

	public MyExample103Service(MyEntity103Repository repository) {
		super(MyExample103DTO.class, MyEntity103.class, null, MyExample103Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample103DTO> doCreateEntity(MyEntity103 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample103DTO> doUpdateEntity(MyEntity103 entity, MyExample103DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample103DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample103DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
			if (!String.valueOf(data.getCustomField()).matches("[A-Za-z]+")) {
				throw new BusinessException().addPopup("The field 'customField' can contain only letters.");
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample103DTO> getActions() {
		return Actions.<MyExample103DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}