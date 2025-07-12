package org.demo.documentation.fields.datetime.validationruntimeex;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class DateTimeValidationRuntimeExService extends
		VersionAwareResponseService<DateTimeValidationRuntimeExDTO, DateTimeValidationRuntimeEx> {

	private final DateTimeValidationRuntimeExRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeValidationRuntimeExMeta> meta = DateTimeValidationRuntimeExMeta.class;

    @Override
	protected CreateResult<DateTimeValidationRuntimeExDTO> doCreateEntity(DateTimeValidationRuntimeEx entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeValidationRuntimeExDTO> doUpdateEntity(DateTimeValidationRuntimeEx entity,
			DateTimeValidationRuntimeExDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeValidationRuntimeExDTO_.customField)) {
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
	public Actions<DateTimeValidationRuntimeExDTO> getActions() {
		return Actions.<DateTimeValidationRuntimeExDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}