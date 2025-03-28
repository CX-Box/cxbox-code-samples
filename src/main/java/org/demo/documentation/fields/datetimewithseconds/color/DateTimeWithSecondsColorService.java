package org.demo.documentation.fields.datetimewithseconds.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class DateTimeWithSecondsColorService extends
		VersionAwareResponseService<DateTimeWithSecondsColorDTO, DateTimeWithSecondsColorEntity> {

	private final DateTimeWithSecondsColorEntityRepository repository;

	public DateTimeWithSecondsColorService(DateTimeWithSecondsColorEntityRepository repository) {
		super(
				DateTimeWithSecondsColorDTO.class,
				DateTimeWithSecondsColorEntity.class,
				null,
				DateTimeWithSecondsColorMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsColorDTO> doCreateEntity(DateTimeWithSecondsColorEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeWithSecondsColorDTO> doUpdateEntity(DateTimeWithSecondsColorEntity entity,
			DateTimeWithSecondsColorDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsColorDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeWithSecondsColorDTO> getActions() {
		return Actions.<DateTimeWithSecondsColorDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}