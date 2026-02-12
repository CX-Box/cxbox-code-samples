package org.demo.documentation.fields.datetimewithseconds.colorconst;

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
public class DateTimeWithSecondsColorConstService extends
		VersionAwareResponseService<DateTimeWithSecondsColorConstDTO, DateTimeWithSecondsColorConstEntity> {

	private final DateTimeWithSecondsColorConstEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateTimeWithSecondsColorConstMeta> meta = DateTimeWithSecondsColorConstMeta.class;

	@Override
	protected CreateResult<DateTimeWithSecondsColorConstDTO> doCreateEntity(DateTimeWithSecondsColorConstEntity entity,
																			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsColorConstDTO> doUpdateEntity(DateTimeWithSecondsColorConstEntity entity,
																			   DateTimeWithSecondsColorConstDTO data, BusinessComponent bc) {

		if (data.isFieldChanged(DateTimeWithSecondsColorConstDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsColorConstDTO> getActions() {
		return Actions.<DateTimeWithSecondsColorConstDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}