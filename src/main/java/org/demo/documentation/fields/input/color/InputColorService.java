package org.demo.documentation.fields.input.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputColorService extends VersionAwareResponseService<InputColorDTO, InputColor> {

	private final InputColorRepository repository;

	public InputColorService(InputColorRepository repository) {
		super(InputColorDTO.class, InputColor.class, null, InputColorMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputColorDTO> doCreateEntity(InputColor entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputColorDTO> doUpdateEntity(InputColor entity, InputColorDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(InputColorDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputColorDTO> getActions() {
		return Actions.<InputColorDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}
