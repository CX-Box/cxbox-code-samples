package org.demo.documentation.fields.dictionary.colorconst;

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
public class MyExample84Service extends VersionAwareResponseService<MyExample84DTO, MyEntity84> {

	private final MyEntity84Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample84Meta> meta = MyExample84Meta.class;

    @Override
	protected CreateResult<MyExample84DTO> doCreateEntity(MyEntity84 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample84DTO> doUpdateEntity(MyEntity84 entity, MyExample84DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample84DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample84DTO> getActions() {
		return Actions.<MyExample84DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}