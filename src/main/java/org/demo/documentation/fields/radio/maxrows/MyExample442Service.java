package org.demo.documentation.fields.radio.maxrows;

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
public class MyExample442Service extends VersionAwareResponseService<MyExample442DTO, MyEntity442> {

	private final MyEntity442Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample442Meta> meta = MyExample442Meta.class;

	@Override
	protected CreateResult<MyExample442DTO> doCreateEntity(MyEntity442 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample442DTO> doUpdateEntity(MyEntity442 entity, MyExample442DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample442DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample442DTO> getActions() {
		return Actions.<MyExample442DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}