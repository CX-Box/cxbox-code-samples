package org.demo.documentation.datetimewithseconds.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeWithSecondsValidationRuntimeExEntityService extends
		VersionAwareResponseService<DateTimeWithSecondsValidationRuntimeExEntityDTO, DateTimeWithSecondsValidationRuntimeExEntity> {

	private final DateTimeWithSecondsValidationRuntimeExEntityRepository repository;

	public DateTimeWithSecondsValidationRuntimeExEntityService(
			DateTimeWithSecondsValidationRuntimeExEntityRepository repository) {
		super(
				DateTimeWithSecondsValidationRuntimeExEntityDTO.class,
				DateTimeWithSecondsValidationRuntimeExEntity.class,
				null,
				DateTimeWithSecondsValidationRuntimeExEntityMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsValidationRuntimeExEntityDTO> doCreateEntity(
			DateTimeWithSecondsValidationRuntimeExEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeWithSecondsValidationRuntimeExEntityDTO> doUpdateEntity(
			DateTimeWithSecondsValidationRuntimeExEntity entity, DateTimeWithSecondsValidationRuntimeExEntityDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsValidationRuntimeExEntityDTO_.customField)) {
			try {
				//call custom function
				throw new Exception("Error");
			} catch (Exception e) {
				throw new RuntimeException("An unexpected error has occurred.");
			}
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeWithSecondsValidationRuntimeExEntityDTO> getActions() {
		return Actions.<DateTimeWithSecondsValidationRuntimeExEntityDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}