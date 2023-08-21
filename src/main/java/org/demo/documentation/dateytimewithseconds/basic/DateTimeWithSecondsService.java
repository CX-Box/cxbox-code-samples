package org.demo.documentation.dateytimewithseconds.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeWithSecondsService extends
		VersionAwareResponseService<DateTimeWithSecondsDTO, DateTimeWithSecondsEntity> {

	private final DateTimeWithSecondsEntityRepository repository;

	public DateTimeWithSecondsService(DateTimeWithSecondsEntityRepository repository) {
		super(DateTimeWithSecondsDTO.class, DateTimeWithSecondsEntity.class, null, DateTimeWithSecondsMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsDTO> doCreateEntity(DateTimeWithSecondsEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeWithSecondsDTO> doUpdateEntity(DateTimeWithSecondsEntity entity,
			DateTimeWithSecondsDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeWithSecondsDTO> getActions() {
		return Actions.<DateTimeWithSecondsDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}