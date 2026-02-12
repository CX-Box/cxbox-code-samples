package org.demo.documentation.fields.input.validationruntimeex;

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
public class InputValidationRuntimeExceptionService extends
		VersionAwareResponseService<InputValidationRuntimeExceptionDTO, InputValidationRuntimeException> {

	private final InputValidationRuntimeExceptionRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<InputValidationRuntimeExceptionMeta> meta = InputValidationRuntimeExceptionMeta.class;

	@Override
	protected CreateResult<InputValidationRuntimeExceptionDTO> doCreateEntity(InputValidationRuntimeException entity,
																			  BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputValidationRuntimeExceptionDTO> doUpdateEntity(InputValidationRuntimeException entity,
																				 InputValidationRuntimeExceptionDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(InputValidationRuntimeExceptionDTO_.customField)) {
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
	public Actions<InputValidationRuntimeExceptionDTO> getActions() {
		return Actions.<InputValidationRuntimeExceptionDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}