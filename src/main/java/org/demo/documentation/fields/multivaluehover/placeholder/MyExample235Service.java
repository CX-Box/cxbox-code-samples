package org.demo.documentation.fields.multivaluehover.placeholder;

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
public class MyExample235Service extends VersionAwareResponseService<MyExample235DTO, MyEntity235> {

	private final MyEntity235Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample235Meta> meta = MyExample235Meta.class;

    @Override
	protected CreateResult<MyExample235DTO> doCreateEntity(MyEntity235 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample235DTO> doUpdateEntity(MyEntity235 entity, MyExample235DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample235DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample235DTO> getActions() {
		return Actions.<MyExample235DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}