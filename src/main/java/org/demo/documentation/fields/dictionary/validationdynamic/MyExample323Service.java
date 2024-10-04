package org.demo.documentation.fields.dictionary.validationdynamic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.dictionary.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@Service
public class MyExample323Service extends VersionAwareResponseService<MyExample323DTO, MyEntity323> {

	private final MyEntity323Repository repository;

	public MyExample323Service(MyEntity323Repository repository) {
		super(MyExample323DTO.class, MyEntity323.class, null, MyExample323Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample323DTO> doCreateEntity(MyEntity323 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample323DTO> doUpdateEntity(MyEntity323 entity, MyExample323DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample323DTO> getActions() {
		return Actions.<MyExample323DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample323DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!dto.getCustomField().getValue().equals(CustomFieldEnum.HIGH.getValue())) {
			entity.addField(MyExample323DTO_.customField.getName(), "Custom message about error");
		}
		if (!dto.getCustomFieldAdditional().getValue().equals(CustomFieldEnum.HIGH.getValue())) {
			entity.addField(MyExample323DTO_.customFieldAdditional.getName(), "Custom message about error");
		}
		if (entity.getFields().size() > 0) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}