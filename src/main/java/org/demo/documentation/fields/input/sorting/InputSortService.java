package org.demo.documentation.fields.input.sorting;

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
public class InputSortService extends VersionAwareResponseService<InputSortDTO, InputSort> {

	private final InputSortRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<InputSortMeta> meta = InputSortMeta.class;

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
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}
