package org.demo.documentation.fields.input.colorconst;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class InputColorConstService extends VersionAwareResponseService<InputColorConstDTO, InputColorConst> {

	private final InputColorConstRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<InputColorConstMeta> meta = InputColorConstMeta.class;

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
				.save(sv -> sv.text("Save").available(bc -> true))
				.build();
	}


}