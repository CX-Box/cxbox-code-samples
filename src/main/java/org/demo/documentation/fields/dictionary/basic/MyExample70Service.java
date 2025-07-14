package org.demo.documentation.fields.dictionary.basic;

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
public class MyExample70Service extends VersionAwareResponseService<MyExample70DTO, MyEntity70> {

	private final MyEntity70Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample70Meta> meta = MyExample70Meta.class;

    @Override
	protected CreateResult<MyExample70DTO> doCreateEntity(MyEntity70 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample70DTO> doUpdateEntity(MyEntity70 entity, MyExample70DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample70DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample70DTO> getActions() {
		return Actions.<MyExample70DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}