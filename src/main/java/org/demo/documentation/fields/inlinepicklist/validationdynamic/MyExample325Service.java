package org.demo.documentation.fields.inlinepicklist.validationdynamic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample325Service extends VersionAwareResponseService<MyExample325DTO, MyEntity325> {

	private final MyEntity325Repository repository;

	public MyExample325Service(MyEntity325Repository repository) {
		super(MyExample325DTO.class, MyEntity325.class, null, MyExample325Meta.class);
		this.repository = repository;

	}

	@Override
	protected CreateResult<MyExample325DTO> doCreateEntity(MyEntity325 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample325DTO> doUpdateEntity(MyEntity325 entity, MyExample325DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample325DTO> getActions() {
		return Actions.<MyExample325DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample325DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (!dto.getCustomField().matches("[A-Za-z]+")) {
			entity.addField(MyExample325DTO_.customField.getName(), "The field 'customField' can contain only letters.");
		}
		if (!dto.getCustomFieldAdditional().matches("[A-Za-z]+")) {
			entity.addField(
					MyExample325DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' can contain only letters."
			);
		}
		if (!entity.getFields().isEmpty()) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}