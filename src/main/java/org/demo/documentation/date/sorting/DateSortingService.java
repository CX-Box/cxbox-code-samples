package org.demo.documentation.date.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateSortingService extends VersionAwareResponseService<DateSortingDTO, DateSortingEntity> {

	private final DateSortingEntityRepository repository;

	public DateSortingService(DateSortingEntityRepository repository) {
		super(DateSortingDTO.class, DateSortingEntity.class, null, DateSortingMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateSortingDTO> doCreateEntity(DateSortingEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateSortingDTO> doUpdateEntity(DateSortingEntity entity, DateSortingDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateSortingDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateSortingDTO> getActions() {
		return Actions.<DateSortingDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}