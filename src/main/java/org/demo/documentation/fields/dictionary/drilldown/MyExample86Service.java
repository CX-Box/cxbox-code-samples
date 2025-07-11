package org.demo.documentation.fields.dictionary.drilldown;

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
public class MyExample86Service extends VersionAwareResponseService<MyExample86DTO, MyEntity86> {

	private final MyEntity86Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample86Meta> meta = MyExample86Meta.class;

    @Override
	protected CreateResult<MyExample86DTO> doCreateEntity(MyEntity86 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample86DTO> doUpdateEntity(MyEntity86 entity, MyExample86DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample86DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample86DTO> getActions() {
		return Actions.<MyExample86DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}