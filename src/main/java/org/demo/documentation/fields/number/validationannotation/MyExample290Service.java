package org.demo.documentation.fields.number.validationannotation;

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
public class MyExample290Service extends VersionAwareResponseService<MyExample290DTO, MyEntity290> {

	private final MyEntity290Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample290Meta> meta = MyExample290Meta.class;

    @Override
	protected CreateResult<MyExample290DTO> doCreateEntity(MyEntity290 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample290DTO> doUpdateEntity(MyEntity290 entity, MyExample290DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample290DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample290DTO> getActions() {
		return Actions.<MyExample290DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}