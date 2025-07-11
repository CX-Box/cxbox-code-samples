package org.demo.documentation.fields.input.filtration;

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
public class InputFiltrationService extends VersionAwareResponseService<InputFiltrationDTO, InputFiltration> {

	private final InputFiltrationRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<InputFiltrationMeta> meta = InputFiltrationMeta.class;

    @Override
	protected CreateResult<InputFiltrationDTO> doCreateEntity(InputFiltration entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputFiltrationDTO> doUpdateEntity(InputFiltration entity, InputFiltrationDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(InputFiltrationDTO_.brand)) {
			entity.setBrand(data.getBrand());
		}
		if (data.isFieldChanged(InputFiltrationDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputFiltrationDTO> getActions() {
		return Actions.<InputFiltrationDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}
