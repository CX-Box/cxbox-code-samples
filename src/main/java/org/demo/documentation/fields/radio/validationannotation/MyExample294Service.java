package org.demo.documentation.fields.radio.validationannotation;

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
public class MyExample294Service extends VersionAwareResponseService<MyExample294DTO, MyEntity294> {

	private final MyEntity294Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample294Meta> meta = MyExample294Meta.class;

    @Override
	protected CreateResult<MyExample294DTO> doCreateEntity(MyEntity294 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample294DTO> doUpdateEntity(MyEntity294 entity, MyExample294DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample294DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample294DTO> getActions() {
		return Actions.<MyExample294DTO>builder()
				.create(crt -> crt.text("Create"))
				.save(sv -> sv.text("Save"))
				.cancelCreate(ccr -> ccr.text("Cancel"))
				.delete(dlt -> dlt.text("Delete"))
				.build();
	}
	// --8<-- [end:getActions]

}