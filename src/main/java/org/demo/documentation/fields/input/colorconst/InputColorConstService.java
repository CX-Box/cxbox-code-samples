package org.demo.documentation.fields.input.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputColorConstService extends VersionAwareResponseService<InputColorConstDTO, InputColorConst> {

	private final InputColorConstRepository repository;

	public InputColorConstService(InputColorConstRepository repository) {
		super(InputColorConstDTO.class, InputColorConst.class, null, InputColorConstMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputColorConstDTO> doCreateEntity(InputColorConst entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputColorConstDTO> doUpdateEntity(InputColorConst entity, InputColorConstDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(InputColorConstDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputColorConstDTO> getActions() {
		return Actions.<InputColorConstDTO>builder()
                .save(sv -> sv.available(bc -> true))
				.build();
	}


}