package org.demo.documentation.fields.hint.color;

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
public class MyExample157Service extends VersionAwareResponseService<MyExample157DTO, MyEntity157> {

	private final MyEntity157Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample157Meta> meta = MyExample157Meta.class;

	@Override
	protected CreateResult<MyExample157DTO> doCreateEntity(MyEntity157 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample157DTO> doUpdateEntity(MyEntity157 entity, MyExample157DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample157DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample157DTO> getActions() {
		return Actions.<MyExample157DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}