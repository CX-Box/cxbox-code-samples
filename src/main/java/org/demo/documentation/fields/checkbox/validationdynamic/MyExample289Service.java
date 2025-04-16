package org.demo.documentation.fields.checkbox.validationdynamic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample289Service extends VersionAwareResponseService<MyExample289DTO, MyEntity289> {

	private final MyEntity289Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample289Meta> meta = MyExample289Meta.class;


    @Override
	protected CreateResult<MyExample289DTO> doCreateEntity(MyEntity289 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample289DTO> doUpdateEntity(MyEntity289 entity, MyExample289DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample289DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample289DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample289DTO> getActions() {
		return Actions.<MyExample289DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample289DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (Boolean.FALSE.equals(dto.getCustomField())) {
			entity.addField(MyExample289DTO_.customField.getName(), "The field 'customField' can contain only 'True");
		}
		if (Boolean.FALSE.equals(dto.getCustomFieldAdditional())) {
			entity.addField(
					MyExample289DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' can contain only 'True"
			);
		}
		if (!entity.getFields().isEmpty()) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}