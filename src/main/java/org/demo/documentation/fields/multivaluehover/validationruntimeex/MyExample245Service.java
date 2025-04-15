package org.demo.documentation.fields.multivaluehover.validationruntimeex;

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
public class MyExample245Service extends VersionAwareResponseService<MyExample245DTO, MyEntity245> {

	private final MyEntity245Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample245Meta> meta = MyExample245Meta.class;

    @Override
	protected CreateResult<MyExample245DTO> doCreateEntity(MyEntity245 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample245DTO> doUpdateEntity(MyEntity245 entity, MyExample245DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample245DTO> getActions() {
		return Actions.<MyExample245DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}