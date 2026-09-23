package org.demo.documentation.fields.richtext.sorting;

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
public class MyExample429Service extends VersionAwareResponseService<MyExample429DTO, MyEntity429> {

	private final MyEntity429Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample429Meta> meta = MyExample429Meta.class;

	@Override
	protected CreateResult<MyExample429DTO> doCreateEntity(MyEntity429 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample429DTO> doUpdateEntity(MyEntity429 entity, MyExample429DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample429DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample429DTO> getActions() {
		return Actions.<MyExample429DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}