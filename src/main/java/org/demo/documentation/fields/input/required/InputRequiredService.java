package org.demo.documentation.fields.input.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputRequiredService extends VersionAwareResponseService<InputRequiredDTO, InputRequired> {

	private final InputRequiredRepository repository;

	public InputRequiredService(InputRequiredRepository repository) {
		super(InputRequiredDTO.class, InputRequired.class, null, InputRequiredMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputRequiredDTO> doCreateEntity(InputRequired entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputRequiredDTO> doUpdateEntity(InputRequired entity, InputRequiredDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(InputRequiredDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputRequiredDTO> getActions() {
		return Actions.<InputRequiredDTO>builder()
				.save().available(bc -> true).add()
				.build();
	}


}