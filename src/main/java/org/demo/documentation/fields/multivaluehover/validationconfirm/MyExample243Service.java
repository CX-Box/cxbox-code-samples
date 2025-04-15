package org.demo.documentation.fields.multivaluehover.validationconfirm;

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
public class MyExample243Service extends VersionAwareResponseService<MyExample243DTO, MyEntity243> {

	private final MyEntity243Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample243Meta> meta = MyExample243Meta.class;

    @Override
	protected CreateResult<MyExample243DTO> doCreateEntity(MyEntity243 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample243DTO> doUpdateEntity(MyEntity243 entity, MyExample243DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample243DTO> getActions() {
		return Actions.<MyExample243DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}