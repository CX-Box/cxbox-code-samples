package org.demo.documentation.fields.number.validationbusinessex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.LESS_20000;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class NumberBusinessExService extends VersionAwareResponseService<NumberBusinessExDTO, NumberBusinessExEntity> {

	private final NumberBusinessExEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<NumberBusinessExMeta> meta = NumberBusinessExMeta.class;

	@Override
	protected CreateResult<NumberBusinessExDTO> doCreateEntity(NumberBusinessExEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberBusinessExDTO> doUpdateEntity(NumberBusinessExEntity entity, NumberBusinessExDTO data,
																  BusinessComponent bc) {
		if (data.isFieldChanged(NumberBusinessExDTO_.customField)) {
			if (data.getCustomField() < 20000) {
				throw new BusinessException().addPopup(LESS_20000);
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberBusinessExDTO> getActions() {
		return Actions.<NumberBusinessExDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}