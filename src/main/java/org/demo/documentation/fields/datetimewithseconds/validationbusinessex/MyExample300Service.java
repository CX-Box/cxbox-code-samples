package org.demo.documentation.fields.datetimewithseconds.validationbusinessex;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static org.demo.documentation.fields.main.TextError.LESS_CURRENT_DATE;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample300Service extends VersionAwareResponseService<MyExample300DTO, MyEntity300> {

	private final MyEntity300Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample300Meta> meta = MyExample300Meta.class;

	@Override
	protected CreateResult<MyExample300DTO> doCreateEntity(MyEntity300 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample300DTO> doUpdateEntity(MyEntity300 entity, MyExample300DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample300DTO_.customField)) {
			if (data.getCustomField() != null && LocalDateTime.now().isAfter(data.getCustomField())) {
				throw new BusinessException().addPopup(LESS_CURRENT_DATE);
			}
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample300DTO> getActions() {
		return Actions.<MyExample300DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}