package org.demo.documentation.fields.radio.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.radio.basic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.ONLY_HIGH;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample29Service extends VersionAwareResponseService<MyExample29DTO, MyEntity29> {

	private final MyEntity29Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample29Meta> meta = MyExample29Meta.class;

    @Override
	protected CreateResult<MyExample29DTO> doCreateEntity(MyEntity29 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample29DTO> doUpdateEntity(MyEntity29 entity, MyExample29DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample29DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
			if (!data.getCustomField().getValue().equals(CustomFieldEnum.HIGH.getValue())) {
				throw new BusinessException().addPopup(ONLY_HIGH);
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample29DTO> getActions() {
		return Actions.<MyExample29DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}