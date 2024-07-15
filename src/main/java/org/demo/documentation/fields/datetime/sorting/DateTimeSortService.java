package org.demo.documentation.fields.datetime.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class DateTimeSortService extends VersionAwareResponseService<DateTimeSortDTO, DateTimeSort> {

	private final DateTimeSortRepository repository;

	public DateTimeSortService(DateTimeSortRepository repository) {
		super(DateTimeSortDTO.class, DateTimeSort.class, null, DateTimeSortMeta.class);
		this.repository = repository;
	}

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
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}