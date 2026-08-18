package org.demo.documentation.widgets.tree.title;

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
public class MyExample3271Service extends VersionAwareResponseService<MyExample3271DTO, MyEntity3271> {

	private final MyEntity3271Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3271Meta> meta = MyExample3271Meta.class;

	@Override
	protected CreateResult<MyExample3271DTO> doCreateEntity(MyEntity3271 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3271DTO> doUpdateEntity(MyEntity3271 entity, MyExample3271DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3271DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3271DTO> getActions() {
		return Actions.<MyExample3271DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}