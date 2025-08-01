package org.demo.documentation.fields.datetime.drilldown;

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
public class DateTimeDrilldownService extends VersionAwareResponseService<DateTimeDrilldownDTO, DateTimeDrilldown> {

	private final DateTimeDrilldownRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeDrilldownMeta> meta = DateTimeDrilldownMeta.class;

    @Override
	protected CreateResult<DateTimeDrilldownDTO> doCreateEntity(DateTimeDrilldown entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeDrilldownDTO> doUpdateEntity(DateTimeDrilldown entity, DateTimeDrilldownDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeDrilldownDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeDrilldownDTO> getActions() {
		return Actions.<DateTimeDrilldownDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}