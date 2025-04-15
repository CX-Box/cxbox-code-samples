package org.demo.documentation.fields.date.validationbusinessex;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.LESS_CURRENT_DATE;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class DateValidationBusinessExService extends
		VersionAwareResponseService<DateValidationBusinessExDTO, DateValidationBusinessExEntity> {

	private final DateValidationBusinessExEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateValidationBusinessExMeta> meta = DateValidationBusinessExMeta.class;

    @Override
	protected CreateResult<DateValidationBusinessExDTO> doCreateEntity(DateValidationBusinessExEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateValidationBusinessExDTO> doUpdateEntity(DateValidationBusinessExEntity entity,
			DateValidationBusinessExDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateValidationBusinessExDTO_.customField)) {
			LocalDateTime sysdate = LocalDateTime.now();
			if (data.getCustomField() != null && sysdate.compareTo(data.getCustomField()) > 0) {
				throw new BusinessException().addPopup(LESS_CURRENT_DATE);
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateValidationBusinessExDTO> getActions() {
		return Actions.<DateValidationBusinessExDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}