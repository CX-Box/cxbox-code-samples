package org.demo.documentation.fields.date.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.date.validationruntimeex.DateValidationRuntimeExEntityDTO_;
import org.springframework.stereotype.Service;

@Service
public class DateValidationRuntimeExEntityService extends
		VersionAwareResponseService<DateValidationRuntimeExEntityDTO, DateValidationRuntimeExEntity> {

	private final DateValidationRuntimeExEntityRepository repository;

	public DateValidationRuntimeExEntityService(DateValidationRuntimeExEntityRepository repository) {
		super(
				DateValidationRuntimeExEntityDTO.class,
				DateValidationRuntimeExEntity.class,
				null,
				DateValidationRuntimeExEntityMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateValidationRuntimeExEntityDTO> doCreateEntity(DateValidationRuntimeExEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateValidationRuntimeExEntityDTO> doUpdateEntity(DateValidationRuntimeExEntity entity,
			DateValidationRuntimeExEntityDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateValidationRuntimeExEntityDTO_.customField)) {
			try {
				//call custom function
				throw new Exception("Error");
			} catch (Exception e) {
				throw new RuntimeException("An unexpected error has occurred.");
			}
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateValidationRuntimeExEntityDTO> getActions() {
		return Actions.<DateValidationRuntimeExEntityDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}