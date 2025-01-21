package org.demo.documentation.fields.datetimewithseconds.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class DateTimeWithSecondsCreateEditService extends
		VersionAwareResponseService<DateTimeWithSecondsCreateEditDTO, DateTimeWithSecondsCreateEditEntity> {

	private final DateTimeWithSecondsCreateEditEntityRepository repository;

	public DateTimeWithSecondsCreateEditService(DateTimeWithSecondsCreateEditEntityRepository repository) {
		super(
				DateTimeWithSecondsCreateEditDTO.class,
				DateTimeWithSecondsCreateEditEntity.class,
				null,
				DateTimeWithSecondsCreateEditMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsCreateEditDTO> doCreateEntity(DateTimeWithSecondsCreateEditEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsCreateEditDTO> doUpdateEntity(DateTimeWithSecondsCreateEditEntity entity,
			DateTimeWithSecondsCreateEditDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsCreateEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsCreateEditDTO> getActions() {
		return Actions.<DateTimeWithSecondsCreateEditDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}