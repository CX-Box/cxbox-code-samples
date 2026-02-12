package org.demo.documentation.fields.datetimewithseconds.basic;

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
public class DateTimeWithSecondsService extends
		VersionAwareResponseService<DateTimeWithSecondsDTO, DateTimeWithSecondsEntity> {

	private final DateTimeWithSecondsEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateTimeWithSecondsMeta> meta = DateTimeWithSecondsMeta.class;

	@Override
	protected CreateResult<DateTimeWithSecondsDTO> doCreateEntity(DateTimeWithSecondsEntity entity,
																  BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsDTO> doUpdateEntity(DateTimeWithSecondsEntity entity,
																	 DateTimeWithSecondsDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsDTO> getActions() {
		return Actions.<DateTimeWithSecondsDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}