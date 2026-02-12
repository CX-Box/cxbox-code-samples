package org.demo.documentation.fields.hint.basic;

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
public class MyExample156Service extends VersionAwareResponseService<MyExample156DTO, MyEntity156> {

	private final MyEntity156Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample156Meta> meta = MyExample156Meta.class;

	@Override
	protected CreateResult<MyExample156DTO> doCreateEntity(MyEntity156 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample156DTO> doUpdateEntity(MyEntity156 entity, MyExample156DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample156DTO_.textField)) {
			entity.setTextField(data.getTextField());
		}
		if (data.isFieldChanged(MyExample156DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample156DTO> getActions() {
		return Actions.<MyExample156DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}