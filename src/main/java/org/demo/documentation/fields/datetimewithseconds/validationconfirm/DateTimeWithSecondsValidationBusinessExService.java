package org.demo.documentation.fields.datetimewithseconds.validationconfirm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class DateTimeWithSecondsValidationBusinessExService extends
		VersionAwareResponseService<DateTimeWithSecondsValidationBusinessExDTO, DateTimeWithSecondsValidationBusinessExEntity> {

	private final DateTimeWithSecondsValidationBusinessExEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeWithSecondsValidationBusinessExMeta> meta = DateTimeWithSecondsValidationBusinessExMeta.class;

    @Override
	protected CreateResult<DateTimeWithSecondsValidationBusinessExDTO> doCreateEntity(
			DateTimeWithSecondsValidationBusinessExEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsValidationBusinessExDTO> doUpdateEntity(
			DateTimeWithSecondsValidationBusinessExEntity entity, DateTimeWithSecondsValidationBusinessExDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsValidationBusinessExDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsValidationBusinessExDTO> getActions() {
		return Actions.<DateTimeWithSecondsValidationBusinessExDTO>builder()
                .action(act -> act
                        .action("save", "save")
                        .withPreAction(PreAction.confirm("You want to save the value ?"))
                )
				.build();
	}
	// --8<-- [end:getActions]


}