package org.demo.documentation.fields.text.drilldown;

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
public class MyExample44Service extends VersionAwareResponseService<MyExample44DTO, MyEntity44> {

	private final MyEntity44Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample44Meta> meta = MyExample44Meta.class;

    @Override
	protected CreateResult<MyExample44DTO> doCreateEntity(MyEntity44 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample44DTO> doUpdateEntity(MyEntity44 entity, MyExample44DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample44DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample44DTO> getActions() {
		return Actions.<MyExample44DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}