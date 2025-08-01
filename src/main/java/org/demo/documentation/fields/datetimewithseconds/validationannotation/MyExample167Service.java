package org.demo.documentation.fields.datetimewithseconds.validationannotation;

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
public class MyExample167Service extends VersionAwareResponseService<MyExample167DTO, MyEntity167> {

	private final MyEntity167Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample167Meta> meta = MyExample167Meta.class;

    @Override
	protected CreateResult<MyExample167DTO> doCreateEntity(MyEntity167 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample167DTO> doUpdateEntity(MyEntity167 entity, MyExample167DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample167DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample167DTO> getActions() {
		return Actions.<MyExample167DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}