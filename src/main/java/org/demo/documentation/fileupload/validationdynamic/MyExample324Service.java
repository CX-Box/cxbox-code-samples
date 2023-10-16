package org.demo.documentation.fileupload.validationdynamic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample324Service extends VersionAwareResponseService<MyExample324DTO, MyEntity324> {

	private final MyEntity324Repository repository;

	public MyExample324Service(MyEntity324Repository repository) {
		super(MyExample324DTO.class, MyEntity324.class, null, MyExample324Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample324DTO> doCreateEntity(MyEntity324 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample324DTO> doUpdateEntity(MyEntity324 entity, MyExample324DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample324DTO_.customFieldAdditionalId)) {
			entity.setCustomFieldAdditionalId(data.getCustomFieldAdditionalId());
		}
		if (data.isFieldChanged(MyExample324DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample324DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample324DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample324DTO> getActions() {
		return Actions.<MyExample324DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample324DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
			entity.addField(MyExample324DTO_.customField.getName(), "The field 'customField' can contain only letters.");
		}
		if (!String.valueOf(dto.getCustomFieldAdditional()).matches("[A-Za-z]+")) {
			entity.addField(
					MyExample324DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' can contain only letters."
			);
		}
		if (entity.getFields().size() > 0) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}