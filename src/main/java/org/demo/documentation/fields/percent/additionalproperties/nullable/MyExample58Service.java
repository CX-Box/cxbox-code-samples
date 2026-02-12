package org.demo.documentation.fields.percent.additionalproperties.nullable;

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
public class MyExample58Service extends VersionAwareResponseService<MyExample58DTO, MyEntity58> {

	private final MyEntity58Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample58Meta> meta = MyExample58Meta.class;

	@Override
	protected CreateResult<MyExample58DTO> doCreateEntity(MyEntity58 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample58DTO> doUpdateEntity(MyEntity58 entity, MyExample58DTO data,
															 BusinessComponent bc) {
		if (data.isFieldChanged(MyExample58DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample58DTO> getActions() {
		return Actions.<MyExample58DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}