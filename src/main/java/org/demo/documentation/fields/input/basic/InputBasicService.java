package org.demo.documentation.fields.input.basic;

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
public class InputBasicService extends VersionAwareResponseService<InputBasicDTO, InputBasic> {

	private final InputBasicRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<InputBasicMeta> meta = InputBasicMeta.class;

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
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}
