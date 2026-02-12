package org.demo.documentation.fields.checkbox.color;

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
public class MyExample52Service extends VersionAwareResponseService<MyExample52DTO, MyEntity52> {

	private final MyEntity52Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample52Meta> meta = MyExample52Meta.class;

	@Override
	protected CreateResult<MyExample52DTO> doCreateEntity(MyEntity52 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample52DTO> doUpdateEntity(MyEntity52 entity, MyExample52DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample52DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		if (data.isFieldChanged(MyExample52DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample52DTO> getActions() {
		return Actions.<MyExample52DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}