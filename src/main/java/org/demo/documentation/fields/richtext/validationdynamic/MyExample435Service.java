package org.demo.documentation.fields.richtext.validationdynamic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
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
public class MyExample435Service extends VersionAwareResponseService<MyExample435DTO, MyEntity435> {

	private final MyEntity435Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample435Meta> meta = MyExample435Meta.class;


	@Override
	protected CreateResult<MyExample435DTO> doCreateEntity(MyEntity435 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample435DTO> doUpdateEntity(MyEntity435 entity, MyExample435DTO data,
															  BusinessComponent bc) {
		validateFields(bc, data);
		if (data.isFieldChanged(MyExample435DTO_.customFieldAdditional)) {
			entity.setCustomFieldAdditional(data.getCustomFieldAdditional());
		}
		if (data.isFieldChanged(MyExample435DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample435DTO> getActions() {
		return Actions.<MyExample435DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

	// --8<-- [start:validateFields]
	private void validateFields(BusinessComponent bc, MyExample435DTO dto) {
		BusinessError.Entity entity = new BusinessError.Entity(bc);
		if (StringUtils.length(dto.getCustomField()) > 50) {
			entity.addField(MyExample435DTO_.customField.getName(), "The field 'customField' can contain no more than 50 characters.");
		}
		if (StringUtils.length(dto.getCustomFieldAdditional()) > 50) {
			entity.addField(
					MyExample435DTO_.customFieldAdditional.getName(),
					"The field 'customFieldAdditional' can contain no more than 50 characters."
			);
		}
		if (!entity.getFields().isEmpty()) {
			throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}