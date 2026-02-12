package org.demo.documentation.fields.datetimewithseconds.filtration;

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
public class DateTimeWithSecondsFiltrationService extends
		VersionAwareResponseService<DateTimeWithSecondsFiltrationDTO, DateTimeWithSecondsFiltrationEntity> {

	private final DateTimeWithSecondsFiltrationEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateTimeWithSecondsFiltrationMeta> meta = DateTimeWithSecondsFiltrationMeta.class;

	@Override
	protected CreateResult<DateTimeWithSecondsFiltrationDTO> doCreateEntity(DateTimeWithSecondsFiltrationEntity entity,
																			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsFiltrationDTO> doUpdateEntity(DateTimeWithSecondsFiltrationEntity entity,
																			   DateTimeWithSecondsFiltrationDTO data, BusinessComponent bc) {
		setIfChanged(data, DateTimeWithSecondsFiltrationDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsFiltrationDTO> getActions() {
		return Actions.<DateTimeWithSecondsFiltrationDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}