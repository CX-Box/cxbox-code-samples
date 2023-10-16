package org.demo.documentation.input.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputFiltrationService extends VersionAwareResponseService<InputFiltrationDTO, InputFiltration> {

	private final InputFiltrationRepository repository;

	public InputFiltrationService(InputFiltrationRepository repository) {
		super(InputFiltrationDTO.class, InputFiltration.class, null, InputFiltrationMeta.class);
		this.repository = repository;
	}

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
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}
