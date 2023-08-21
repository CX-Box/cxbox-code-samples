package org.demo.documentation.datetime.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class DateTimeValidationRuntimeExService extends
		VersionAwareResponseService<DateTimeValidationRuntimeExDTO, DateTimeValidationRuntimeEx> {

	private final DateTimeValidationRuntimeExRepository repository;

	public DateTimeValidationRuntimeExService(DateTimeValidationRuntimeExRepository repository) {
		super(
				DateTimeValidationRuntimeExDTO.class,
				DateTimeValidationRuntimeEx.class,
				null,
				DateTimeValidationRuntimeExMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeValidationRuntimeExDTO> doCreateEntity(DateTimeValidationRuntimeEx entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeValidationRuntimeExDTO> doUpdateEntity(DateTimeValidationRuntimeEx entity,
			DateTimeValidationRuntimeExDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeValidationRuntimeExDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
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
	public Actions<DateTimeValidationRuntimeExDTO> getActions() {
		return Actions.<DateTimeValidationRuntimeExDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}