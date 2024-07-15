package org.demo.documentation.fields.input.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputSortService extends VersionAwareResponseService<InputSortDTO, InputSort> {

	private final InputSortRepository repository;

	public InputSortService(InputSortRepository repository) {
		super(InputSortDTO.class, InputSort.class, null, InputSortMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputSortDTO> doCreateEntity(InputSort entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<InputSortDTO> doUpdateEntity(InputSort entity, InputSortDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(InputSortDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<InputSortDTO> getActions() {
		return Actions.<InputSortDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}
