package org.demo.documentation.fields.datetimewithseconds.placeholder;

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
public class DateTimeWithSecondsPlaceholderService extends
		VersionAwareResponseService<DateTimeWithSecondsPlaceholderDTO, DateTimeWithSecondsPlaceholderEntity> {

	private final DateTimeWithSecondsPlaceholderEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeWithSecondsPlaceholderMeta> meta = DateTimeWithSecondsPlaceholderMeta.class;

    @Override
	protected CreateResult<DateTimeWithSecondsPlaceholderDTO> doCreateEntity(DateTimeWithSecondsPlaceholderEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsPlaceholderDTO> doUpdateEntity(
			DateTimeWithSecondsPlaceholderEntity entity, DateTimeWithSecondsPlaceholderDTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsPlaceholderDTO> getActions() {
		return Actions.<DateTimeWithSecondsPlaceholderDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}