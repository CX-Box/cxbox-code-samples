package org.demo.documentation.fields.input.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputCreateEditService extends VersionAwareResponseService<InputCreateEditDTO, InputCreateEdit> {

	private final InputCreateEditRepository repository;

	public InputCreateEditService(InputCreateEditRepository repository) {
		super(InputCreateEditDTO.class, InputCreateEdit.class, null, InputCreateEditMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputCreateEditDTO> doCreateEntity(InputCreateEdit entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputCreateEditDTO> doUpdateEntity(InputCreateEdit entity, InputCreateEditDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(InputCreateEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputCreateEditDTO> getActions() {
		return Actions.<InputCreateEditDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}
