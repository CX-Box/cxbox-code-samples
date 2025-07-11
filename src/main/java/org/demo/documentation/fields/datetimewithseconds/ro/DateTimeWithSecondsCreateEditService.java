package org.demo.documentation.fields.datetimewithseconds.ro;

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
public class DateTimeWithSecondsCreateEditService extends
		VersionAwareResponseService<DateTimeWithSecondsCreateEditDTO, DateTimeWithSecondsCreateEditEntity> {

	private final DateTimeWithSecondsCreateEditEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeWithSecondsCreateEditMeta> meta = DateTimeWithSecondsCreateEditMeta.class;

    @Override
	protected CreateResult<DateTimeWithSecondsCreateEditDTO> doCreateEntity(DateTimeWithSecondsCreateEditEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsCreateEditDTO> doUpdateEntity(DateTimeWithSecondsCreateEditEntity entity,
			DateTimeWithSecondsCreateEditDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsCreateEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsCreateEditDTO> getActions() {
		return Actions.<DateTimeWithSecondsCreateEditDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}