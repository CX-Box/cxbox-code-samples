package org.demo.documentation.fields.datetimewithseconds.sorting;

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
public class DateTimeWithSecondsSortingService extends
		VersionAwareResponseService<DateTimeWithSecondsSortingDTO, DateTimeWithSecondsSortingEntity> {

	private final DateTimeWithSecondsSortingEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateTimeWithSecondsSortingMeta> meta = DateTimeWithSecondsSortingMeta.class;

	@Override
	protected CreateResult<DateTimeWithSecondsSortingDTO> doCreateEntity(DateTimeWithSecondsSortingEntity entity,
																		 BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsSortingDTO> doUpdateEntity(DateTimeWithSecondsSortingEntity entity,
																			DateTimeWithSecondsSortingDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsSortingDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsSortingDTO> getActions() {
		return Actions.<DateTimeWithSecondsSortingDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}