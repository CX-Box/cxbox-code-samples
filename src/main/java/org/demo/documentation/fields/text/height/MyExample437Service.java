package org.demo.documentation.fields.text.height;

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
public class MyExample437Service extends VersionAwareResponseService<MyExample437DTO, MyEntity437> {

	private final MyEntity437Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample437Meta> meta = MyExample437Meta.class;

	@Override
	protected CreateResult<MyExample437DTO> doCreateEntity(MyEntity437 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample437DTO> doUpdateEntity(MyEntity437 entity, MyExample437DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample437DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample437DTO> getActions() {
		return Actions.<MyExample437DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}