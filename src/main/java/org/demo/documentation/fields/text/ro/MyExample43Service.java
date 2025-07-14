package org.demo.documentation.fields.text.ro;

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
public class MyExample43Service extends VersionAwareResponseService<MyExample43DTO, MyEntity43> {

	private final MyEntity43Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample43Meta> meta = MyExample43Meta.class;

    @Override
	protected CreateResult<MyExample43DTO> doCreateEntity(MyEntity43 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample43DTO> doUpdateEntity(MyEntity43 entity, MyExample43DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample43DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample43DTO> getActions() {
		return Actions.<MyExample43DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}