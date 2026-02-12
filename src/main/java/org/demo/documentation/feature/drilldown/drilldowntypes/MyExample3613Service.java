package org.demo.documentation.feature.drilldown.drilldowntypes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3613Service extends VersionAwareResponseService<MyExample3613DTO, MyEntity3613> {

	private final MyEntity3613Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample3613Meta> meta = MyExample3613Meta.class;

	@Override
	protected CreateResult<MyExample3613DTO> doCreateEntity(MyEntity3613 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample3613DTO> doUpdateEntity(MyEntity3613 entity, MyExample3613DTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3613DTO_.customFieldRelativeNew)) {
			entity.setCustomFieldRelativeNew(data.getCustomFieldRelativeNew());
		}
		if (data.isFieldChanged(MyExample3613DTO_.customFieldRelative)) {
			entity.setCustomFieldRelative(data.getCustomFieldRelative());
		}
		if (data.isFieldChanged(MyExample3613DTO_.customFieldExternalNew)) {
			entity.setCustomFieldExternalNew(data.getCustomFieldExternalNew());
		}
		if (data.isFieldChanged(MyExample3613DTO_.customFieldExternal)) {
			entity.setCustomFieldExternal(data.getCustomFieldExternal());
		}
		if (data.isFieldChanged(MyExample3613DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3613DTO> getActions() {
		return Actions.<MyExample3613DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}
