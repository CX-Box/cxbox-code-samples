package org.demo.documentation.fields.input.validationbusinessex;

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

import static org.demo.documentation.fields.main.TextError.ONLY_LETTER;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class InputValidationBusinessExceptionService extends
		VersionAwareResponseService<InputValidationBusinessExceptionDTO, InputValidationBusinessExc> {

	private final InputValidationBusinessExceptionRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<InputValidationBusinessExceptionMeta> meta = InputValidationBusinessExceptionMeta.class;

    @Override
	protected CreateResult<InputValidationBusinessExceptionDTO> doCreateEntity(InputValidationBusinessExc entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputValidationBusinessExceptionDTO> doUpdateEntity(InputValidationBusinessExc entity,
			InputValidationBusinessExceptionDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(InputValidationBusinessExceptionDTO_.customField)) {
			if (StringUtils.isNotEmpty(data.getCustomField())
					&& !String.valueOf(data.getCustomField()).matches("[A-Za-z]+")
			) {
				throw new BusinessException().addPopup(ONLY_LETTER);
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputValidationBusinessExceptionDTO> getActions() {
		return Actions.<InputValidationBusinessExceptionDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}