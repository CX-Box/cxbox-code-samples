package org.demo.documentation.fields.money.withoutdigits;

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
public class MyExample305Service extends VersionAwareResponseService<MyExample305DTO, MyEntity305> {

	private final MyEntity305Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample305Meta> meta = MyExample305Meta.class;

    @Override
	protected CreateResult<MyExample305DTO> doCreateEntity(MyEntity305 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample305DTO> doUpdateEntity(MyEntity305 entity, MyExample305DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample305DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample305DTO> getActions() {
		return Actions.<MyExample305DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}