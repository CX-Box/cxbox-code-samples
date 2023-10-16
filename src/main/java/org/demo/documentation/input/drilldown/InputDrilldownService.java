package org.demo.documentation.input.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputDrilldownService extends VersionAwareResponseService<InputDrilldownDTO, InputDrilldown> {

	private final InputDrilldownRepository repository;

	public InputDrilldownService(InputDrilldownRepository repository) {
		super(InputDrilldownDTO.class, InputDrilldown.class, null, InputDrilldownMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputDrilldownDTO> doCreateEntity(InputDrilldown entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputDrilldownDTO> doUpdateEntity(InputDrilldown entity, InputDrilldownDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(InputDrilldownDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputDrilldownDTO> getActions() {
		return Actions.<InputDrilldownDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}
