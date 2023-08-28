package org.demo.documentation.datetimewithseconds.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeWithSecondsSortingService extends
		VersionAwareResponseService<DateTimeWithSecondsSortingDTO, DateTimeWithSecondsSortingEntity> {

	private final DateTimeWithSecondsSortingEntityRepository repository;

	public DateTimeWithSecondsSortingService(DateTimeWithSecondsSortingEntityRepository repository) {
		super(
				DateTimeWithSecondsSortingDTO.class,
				DateTimeWithSecondsSortingEntity.class,
				null,
				DateTimeWithSecondsSortingMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsSortingDTO> doCreateEntity(DateTimeWithSecondsSortingEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeWithSecondsSortingDTO> doUpdateEntity(DateTimeWithSecondsSortingEntity entity,
			DateTimeWithSecondsSortingDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsSortingDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeWithSecondsSortingDTO> getActions() {
		return Actions.<DateTimeWithSecondsSortingDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}