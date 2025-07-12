package org.demo.documentation.fields.dictionary.ro;

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
public class MyExample85Service extends VersionAwareResponseService<MyExample85DTO, MyEntity85> {

	private final MyEntity85Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample85Meta> meta = MyExample85Meta.class;

    @Override
	protected CreateResult<MyExample85DTO> doCreateEntity(MyEntity85 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample85DTO> doUpdateEntity(MyEntity85 entity, MyExample85DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample85DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample85DTO> getActions() {
		return Actions.<MyExample85DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}