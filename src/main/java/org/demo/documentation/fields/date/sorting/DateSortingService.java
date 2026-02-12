package org.demo.documentation.fields.date.sorting;

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
public class DateSortingService extends VersionAwareResponseService<DateSortingDTO, DateSortingEntity> {

	private final DateSortingEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateSortingMeta> meta = DateSortingMeta.class;

	@Override
	protected CreateResult<DateSortingDTO> doCreateEntity(DateSortingEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateSortingDTO> doUpdateEntity(DateSortingEntity entity, DateSortingDTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(DateSortingDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateSortingDTO> getActions() {
		return Actions.<DateSortingDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}