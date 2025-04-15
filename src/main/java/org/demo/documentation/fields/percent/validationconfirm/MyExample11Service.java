package org.demo.documentation.fields.percent.validationconfirm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample11Service extends VersionAwareResponseService<MyExample11DTO, MyEntity11> {

	private final MyEntity11Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample11Meta> meta = MyExample11Meta.class;

    @Override
	protected CreateResult<MyExample11DTO> doCreateEntity(MyEntity11 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample11DTO> doUpdateEntity(MyEntity11 entity, MyExample11DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample11DTO> getActions() {
		return Actions.<MyExample11DTO>builder()
                .action(act -> act
                        .action("save", "save")
                        .withPreAction(PreAction.confirm("You want to save the value ?"))
                )
				.build();
	}
	// --8<-- [end:getActions]

}