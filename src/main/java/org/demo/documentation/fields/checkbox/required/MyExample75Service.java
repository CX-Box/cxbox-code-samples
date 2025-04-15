package org.demo.documentation.fields.checkbox.required;

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
public class MyExample75Service extends VersionAwareResponseService<MyExample75DTO, MyEntity75> {

	private final MyEntity75Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample75Meta> meta = MyExample75Meta.class;

    @Override
	protected CreateResult<MyExample75DTO> doCreateEntity(MyEntity75 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample75DTO> doUpdateEntity(MyEntity75 entity, MyExample75DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample75DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample75DTO> getActions() {
		return Actions.<MyExample75DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}