package org.demo.documentation.datetimewithseconds.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeWithSecondsFiltrationService extends
		VersionAwareResponseService<DateTimeWithSecondsFiltrationDTO, DateTimeWithSecondsFiltrationEntity> {

	private final DateTimeWithSecondsFiltrationEntityRepository repository;

	public DateTimeWithSecondsFiltrationService(DateTimeWithSecondsFiltrationEntityRepository repository) {
		super(
				DateTimeWithSecondsFiltrationDTO.class,
				DateTimeWithSecondsFiltrationEntity.class,
				null,
				DateTimeWithSecondsFiltrationMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsFiltrationDTO> doCreateEntity(DateTimeWithSecondsFiltrationEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeWithSecondsFiltrationDTO> doUpdateEntity(DateTimeWithSecondsFiltrationEntity entity,
			DateTimeWithSecondsFiltrationDTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeWithSecondsFiltrationDTO> getActions() {
		return Actions.<DateTimeWithSecondsFiltrationDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}