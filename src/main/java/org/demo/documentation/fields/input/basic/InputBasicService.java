package org.demo.documentation.fields.input.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputBasicService extends VersionAwareResponseService<InputBasicDTO, InputBasic> {

	private final InputBasicRepository repository;

	public InputBasicService(InputBasicRepository repository) {
		super(InputBasicDTO.class, InputBasic.class, null, InputBasicMeta.class);
		this.repository = repository;
	}
	// --8<-- [start:doCreateEntity]
	@Override
	protected CreateResult<InputBasicDTO> doCreateEntity(InputBasic entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doCreateEntity]

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputBasicDTO> doUpdateEntity(InputBasic entity, InputBasicDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(InputBasicDTO_.customFieldRO)) {
			entity.setCustomFieldRO(data.getCustomFieldRO());
		}
		if (data.isFieldChanged(InputBasicDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputBasicDTO> getActions() {
		return Actions.<InputBasicDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}
