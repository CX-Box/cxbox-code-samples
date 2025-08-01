package org.demo.documentation.fields.checkbox.validationannotation;

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
public class MyExample168Service extends VersionAwareResponseService<MyExample168DTO, MyEntity168> {

	private final MyEntity168Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample168Meta> meta = MyExample168Meta.class;

    @Override
	protected CreateResult<MyExample168DTO> doCreateEntity(MyEntity168 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample168DTO> doUpdateEntity(MyEntity168 entity, MyExample168DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample168DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample168DTO> getActions() {
		return Actions.<MyExample168DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}