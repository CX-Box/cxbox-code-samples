package org.demo.documentation.fields.richtext.validationannotation;

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
public class MyExample434Service extends VersionAwareResponseService<MyExample434DTO, MyEntity434> {

	private final MyEntity434Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample434Meta> meta = MyExample434Meta.class;

	@Override
	protected CreateResult<MyExample434DTO> doCreateEntity(MyEntity434 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample434DTO> doUpdateEntity(MyEntity434 entity, MyExample434DTO data,
															  BusinessComponent bc) {
		if (data.isFieldChanged(MyExample434DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample434DTO> getActions() {
		return Actions.<MyExample434DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}