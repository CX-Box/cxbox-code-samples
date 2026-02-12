package org.demo.documentation.fields.number.additionalproperties.nullable;

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
public class MyExample57Service extends VersionAwareResponseService<MyExample57DTO, MyEntity57> {

	private final MyEntity57Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample57Meta> meta = MyExample57Meta.class;

	@Override
	protected CreateResult<MyExample57DTO> doCreateEntity(MyEntity57 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample57DTO> doUpdateEntity(MyEntity57 entity, MyExample57DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample57DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample57DTO> getActions() {
		return Actions.<MyExample57DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}