package org.demo.documentation.fields.richtext.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.MAX_50_CHARACTERS;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample431Service extends VersionAwareResponseService<MyExample431DTO, MyEntity431> {

	private final MyEntity431Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample431Meta> meta = MyExample431Meta.class;

	@Override
	protected CreateResult<MyExample431DTO> doCreateEntity(MyEntity431 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample431DTO> doUpdateEntity(MyEntity431 entity, MyExample431DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample431DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
			if (StringUtils.length(data.getCustomField()) > 50) {
				throw new BusinessException().addPopup(MAX_50_CHARACTERS);
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample431DTO> getActions() {
		return Actions.<MyExample431DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}