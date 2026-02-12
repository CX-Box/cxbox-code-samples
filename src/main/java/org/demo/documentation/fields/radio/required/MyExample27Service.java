package org.demo.documentation.fields.radio.required;

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
public class MyExample27Service extends VersionAwareResponseService<MyExample27DTO, MyEntity27> {

	private final MyEntity27Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample27Meta> meta = MyExample27Meta.class;

	@Override
	protected CreateResult<MyExample27DTO> doCreateEntity(MyEntity27 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample27DTO> doUpdateEntity(MyEntity27 entity, MyExample27DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample27DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample27DTO> getActions() {
		return Actions.<MyExample27DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}