package org.demo.documentation.fields.date.validationannotation;

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
public class MyExample165Service extends VersionAwareResponseService<MyExample165DTO, MyEntity165> {

	private final MyEntity165Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample165Meta> meta = MyExample165Meta.class;

	@Override
	protected CreateResult<MyExample165DTO> doCreateEntity(MyEntity165 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample165DTO> doUpdateEntity(MyEntity165 entity, MyExample165DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample165DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample165DTO> getActions() {
		return Actions.<MyExample165DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}