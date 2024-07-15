package org.demo.documentation.fields.input.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputValidationService extends VersionAwareResponseService<InputValidationDTO, InputValidation> {

	private final InputValidationRepository repository;

	public InputValidationService(InputValidationRepository repository) {
		super(InputValidationDTO.class, InputValidation.class, null, InputValidationMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputValidationDTO> doCreateEntity(InputValidation entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputValidationDTO> doUpdateEntity(InputValidation entity, InputValidationDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(InputValidationDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputValidationDTO> getActions() {
		return Actions.<InputValidationDTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value ?"))
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}