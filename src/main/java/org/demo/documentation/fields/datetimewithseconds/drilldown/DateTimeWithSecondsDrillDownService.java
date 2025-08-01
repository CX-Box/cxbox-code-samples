package org.demo.documentation.fields.datetimewithseconds.drilldown;

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
public class DateTimeWithSecondsDrillDownService extends
		VersionAwareResponseService<DateTimeWithSecondsDrillDownDTO, DateTimeWithSecondsDrillDownEntity> {

	private final DateTimeWithSecondsDrillDownEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeWithSecondsDrillDownMeta> meta = DateTimeWithSecondsDrillDownMeta.class;

    @Override
	protected CreateResult<DateTimeWithSecondsDrillDownDTO> doCreateEntity(DateTimeWithSecondsDrillDownEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsDrillDownDTO> doUpdateEntity(DateTimeWithSecondsDrillDownEntity entity,
			DateTimeWithSecondsDrillDownDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsDrillDownDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsDrillDownDTO> getActions() {
		return Actions.<DateTimeWithSecondsDrillDownDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}