package org.demo.documentation.datetimewithseconds.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class DateTimeWithSecondsPlaceholderService extends
		VersionAwareResponseService<DateTimeWithSecondsPlaceholderDTO, DateTimeWithSecondsPlaceholderEntity> {

	private final DateTimeWithSecondsPlaceholderEntityRepository repository;

	public DateTimeWithSecondsPlaceholderService(DateTimeWithSecondsPlaceholderEntityRepository repository) {
		super(
				DateTimeWithSecondsPlaceholderDTO.class,
				DateTimeWithSecondsPlaceholderEntity.class,
				null,
				DateTimeWithSecondsPlaceholderMeta.class
		);
		this.repository = repository;
	}

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
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}