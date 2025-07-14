package org.demo.documentation.fields.text.placeholder;

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
public class MyExample46Service extends VersionAwareResponseService<MyExample46DTO, MyEntity46> {

	private final MyEntity46Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample46Meta> meta = MyExample46Meta.class;

    @Override
	protected CreateResult<MyExample46DTO> doCreateEntity(MyEntity46 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample46DTO> doUpdateEntity(MyEntity46 entity, MyExample46DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample46DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample46DTO> getActions() {
		return Actions.<MyExample46DTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}