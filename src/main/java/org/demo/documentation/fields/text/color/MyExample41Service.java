package org.demo.documentation.fields.text.color;

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
public class MyExample41Service extends VersionAwareResponseService<MyExample41DTO, MyEntity41> {

	private final MyEntity41Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample41Meta> meta = MyExample41Meta.class;

    @Override
	protected CreateResult<MyExample41DTO> doCreateEntity(MyEntity41 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample41DTO> doUpdateEntity(MyEntity41 entity, MyExample41DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample41DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample41DTO> getActions() {
		return Actions.<MyExample41DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}