package org.demo.documentation.fields.datetime.validationdynamic;

import java.time.LocalDateTime;

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
public class MyExample321Service extends VersionAwareResponseService<MyExample321DTO, MyEntity321> {

	private final MyEntity321Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample321Meta> meta = MyExample321Meta.class;


    @Override
	protected CreateResult<MyExample321DTO> doCreateEntity(MyEntity321 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample321DTO> doUpdateEntity(MyEntity321 entity, MyExample321DTO data,
			BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample321DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample321DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample321DTO> getActions() {
		return Actions.<MyExample321DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample321DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		LocalDateTime sysdate = LocalDateTime.now();
		if (dto.getCustomField() != null && sysdate.isAfter(dto.getCustomField())) {
			entity.addField(MyExample321DTO_.customField.getName(),
					"The field 'customField' cannot be less than the current date");
		}
		if (dto.getCustomField() != null && sysdate.isAfter(dto.getCustomFieldAdditional())) {
			entity.addField(
					MyExample321DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' cannot be less than the current date"
			);
		}
		if (!entity.getFields().isEmpty()) {
				throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}