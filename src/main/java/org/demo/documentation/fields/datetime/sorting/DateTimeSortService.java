package org.demo.documentation.fields.datetime.sorting;

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
public class DateTimeSortService extends VersionAwareResponseService<DateTimeSortDTO, DateTimeSort> {

	private final DateTimeSortRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeSortMeta> meta = DateTimeSortMeta.class;

    @Override
	protected CreateResult<DateTimeSortDTO> doCreateEntity(DateTimeSort entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeSortDTO> doUpdateEntity(DateTimeSort entity, DateTimeSortDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeSortDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeSortDTO> getActions() {
		return Actions.<DateTimeSortDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}