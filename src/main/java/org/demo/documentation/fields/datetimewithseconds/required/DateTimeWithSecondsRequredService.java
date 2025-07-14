package org.demo.documentation.fields.datetimewithseconds.required;

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
public class DateTimeWithSecondsRequredService extends
		VersionAwareResponseService<DateTimeWithSecondsRequredDTO, DateTimeWithSecondsRequredEntity> {

	private final DateTimeWithSecondsRequredEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeWithSecondsRequredMeta> meta = DateTimeWithSecondsRequredMeta.class;

    @Override
	protected CreateResult<DateTimeWithSecondsRequredDTO> doCreateEntity(DateTimeWithSecondsRequredEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsRequredDTO> doUpdateEntity(DateTimeWithSecondsRequredEntity entity,
			DateTimeWithSecondsRequredDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsRequredDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsRequredDTO> getActions() {
		return Actions.<DateTimeWithSecondsRequredDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}