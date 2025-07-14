package org.demo.documentation.fields.datetimewithseconds.validationruntimeex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class DateTimeWithSecondsValidationRuntimeExEntityService extends
		VersionAwareResponseService<DateTimeWithSecondsValidationRuntimeExEntityDTO, DateTimeWithSecondsValidationRuntimeExEntity> {

	private final DateTimeWithSecondsValidationRuntimeExEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeWithSecondsValidationRuntimeExEntityMeta> meta = DateTimeWithSecondsValidationRuntimeExEntityMeta.class;

    @Override
	protected CreateResult<DateTimeWithSecondsValidationRuntimeExEntityDTO> doCreateEntity(
			DateTimeWithSecondsValidationRuntimeExEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsValidationRuntimeExEntityDTO> doUpdateEntity(
			DateTimeWithSecondsValidationRuntimeExEntity entity, DateTimeWithSecondsValidationRuntimeExEntityDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsValidationRuntimeExEntityDTO_.customField)) {
			try {
				//call custom function
				throw new Exception("Error");
			} catch (Exception e) {
				throw new RuntimeException("An unexpected error has occurred.");
			}
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsValidationRuntimeExEntityDTO> getActions() {
		return Actions.<DateTimeWithSecondsValidationRuntimeExEntityDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}