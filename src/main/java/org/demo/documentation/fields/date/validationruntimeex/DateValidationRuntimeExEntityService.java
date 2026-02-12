package org.demo.documentation.fields.date.validationruntimeex;

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
public class DateValidationRuntimeExEntityService extends
		VersionAwareResponseService<DateValidationRuntimeExEntityDTO, DateValidationRuntimeExEntity> {

	private final DateValidationRuntimeExEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateValidationRuntimeExEntityMeta> meta = DateValidationRuntimeExEntityMeta.class;

	@Override
	protected CreateResult<DateValidationRuntimeExEntityDTO> doCreateEntity(DateValidationRuntimeExEntity entity,
																			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateValidationRuntimeExEntityDTO> doUpdateEntity(DateValidationRuntimeExEntity entity,
																			   DateValidationRuntimeExEntityDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateValidationRuntimeExEntityDTO_.customField)) {
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
	public Actions<DateValidationRuntimeExEntityDTO> getActions() {
		return Actions.<DateValidationRuntimeExEntityDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}