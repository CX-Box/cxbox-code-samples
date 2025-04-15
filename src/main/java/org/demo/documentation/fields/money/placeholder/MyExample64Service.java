package org.demo.documentation.fields.money.placeholder;

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
public class MyExample64Service extends VersionAwareResponseService<MyExample64DTO, MyEntity64> {

	private final MyEntity64Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample64Meta> meta = MyExample64Meta.class;

    @Override
	protected CreateResult<MyExample64DTO> doCreateEntity(MyEntity64 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample64DTO> doUpdateEntity(MyEntity64 entity, MyExample64DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample64DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample64DTO> getActions() {
		return Actions.<MyExample64DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}