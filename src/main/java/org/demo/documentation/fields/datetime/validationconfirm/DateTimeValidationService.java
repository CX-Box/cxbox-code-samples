package org.demo.documentation.fields.datetime.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class DateTimeValidationService extends VersionAwareResponseService<DateTimeValidationDTO, DateTimeValidation> {

	private final DateTimeValidationRepository repository;

	public DateTimeValidationService(DateTimeValidationRepository repository) {
		super(DateTimeValidationDTO.class, DateTimeValidation.class, null, DateTimeValidationMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeValidationDTO> doCreateEntity(DateTimeValidation entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeValidationDTO> doUpdateEntity(DateTimeValidation entity, DateTimeValidationDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeValidationDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeValidationDTO> getActions() {
		return Actions.<DateTimeValidationDTO>builder()
                .action(act -> act
                        .action("save", "save")
                        .withPreAction(PreAction.confirm("You want to save the value ?"))
                )
				.build();
	}
	// --8<-- [end:getActions]

}