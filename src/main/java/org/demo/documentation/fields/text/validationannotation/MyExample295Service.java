package org.demo.documentation.fields.text.validationannotation;

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
public class MyExample295Service extends VersionAwareResponseService<MyExample295DTO, MyEntity295> {

	private final MyEntity295Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample295Meta> meta = MyExample295Meta.class;

    @Override
	protected CreateResult<MyExample295DTO> doCreateEntity(MyEntity295 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample295DTO> doUpdateEntity(MyEntity295 entity, MyExample295DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample295DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample295DTO> getActions() {
		return Actions.<MyExample295DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}