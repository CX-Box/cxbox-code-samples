package org.demo.documentation.fields.radio.displaymode;

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
public class MyExample441Service extends VersionAwareResponseService<MyExample441DTO, MyEntity441> {

	private final MyEntity441Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample441Meta> meta = MyExample441Meta.class;

	@Override
	protected CreateResult<MyExample441DTO> doCreateEntity(MyEntity441 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample441DTO> doUpdateEntity(MyEntity441 entity, MyExample441DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample441DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample441DTO> getActions() {
		return Actions.<MyExample441DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}