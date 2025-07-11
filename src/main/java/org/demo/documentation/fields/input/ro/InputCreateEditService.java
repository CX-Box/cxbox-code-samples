package org.demo.documentation.fields.input.ro;

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
public class InputCreateEditService extends VersionAwareResponseService<InputCreateEditDTO, InputCreateEdit> {

	private final InputCreateEditRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<InputCreateEditMeta> meta = InputCreateEditMeta.class;

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
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}
