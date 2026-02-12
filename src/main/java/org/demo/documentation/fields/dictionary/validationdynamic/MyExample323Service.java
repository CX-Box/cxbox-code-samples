package org.demo.documentation.fields.dictionary.validationdynamic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.dictionary.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample323Service extends VersionAwareResponseService<MyExample323DTO, MyEntity323> {

	private final MyEntity323Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample323Meta> meta = MyExample323Meta.class;

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
				.save(sv -> sv.text("Save"))
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
		if (!entity.getFields().isEmpty()) {
			throw new BusinessException().setEntity(entity);
		}
	}
	// --8<-- [end:validateFields]

}