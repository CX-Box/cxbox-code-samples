package org.demo.documentation.datetimewithseconds.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeWithSecondsColorConstService extends
		VersionAwareResponseService<DateTimeWithSecondsColorConstDTO, DateTimeWithSecondsColorConstEntity> {

	private final DateTimeWithSecondsColorConstEntityRepository repository;

	public DateTimeWithSecondsColorConstService(DateTimeWithSecondsColorConstEntityRepository repository) {
		super(
				DateTimeWithSecondsColorConstDTO.class,
				DateTimeWithSecondsColorConstEntity.class,
				null,
				DateTimeWithSecondsColorConstMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsColorConstDTO> doCreateEntity(DateTimeWithSecondsColorConstEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeWithSecondsColorConstDTO> doUpdateEntity(DateTimeWithSecondsColorConstEntity entity,
			DateTimeWithSecondsColorConstDTO data, BusinessComponent bc) {

		if (data.isFieldChanged(DateTimeWithSecondsColorConstDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeWithSecondsColorConstDTO> getActions() {
		return Actions.<DateTimeWithSecondsColorConstDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}