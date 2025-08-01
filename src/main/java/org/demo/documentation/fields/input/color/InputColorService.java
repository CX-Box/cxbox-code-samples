package org.demo.documentation.fields.input.color;

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
public class InputColorService extends VersionAwareResponseService<InputColorDTO, InputColor> {

	private final InputColorRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<InputColorMeta> meta = InputColorMeta.class;

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
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}
