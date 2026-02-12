package org.demo.documentation.fields.date.drilldown;

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
public class DateDrillDownService extends VersionAwareResponseService<DateDrillDownDTO, dateDrillDownEntity> {

	private final dateDrillDownEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateDrillDownMeta> meta = DateDrillDownMeta.class;

	@Override
	protected CreateResult<DateDrillDownDTO> doCreateEntity(dateDrillDownEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateDrillDownDTO> doUpdateEntity(dateDrillDownEntity entity, DateDrillDownDTO data,
															   BusinessComponent bc) {
		if (data.isFieldChanged(DateDrillDownDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateDrillDownDTO> getActions() {
		return Actions.<DateDrillDownDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}