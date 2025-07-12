package org.demo.documentation.fields.money.validationannotation;

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
public class MyExample271Service extends VersionAwareResponseService<MyExample271DTO, MyEntity271> {

	private final MyEntity271Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample271Meta> meta = MyExample271Meta.class;

    @Override
	protected CreateResult<MyExample271DTO> doCreateEntity(MyEntity271 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample271DTO> doUpdateEntity(MyEntity271 entity, MyExample271DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample271DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample271DTO> getActions() {
		return Actions.<MyExample271DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}