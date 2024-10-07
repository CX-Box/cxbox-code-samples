package org.demo.documentation.fields.money.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample61Service extends VersionAwareResponseService<MyExample61DTO, MyEntity61> {

	private final MyEntity61Repository repository;

	public MyExample61Service(MyEntity61Repository repository) {
		super(MyExample61DTO.class, MyEntity61.class, null, MyExample61Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample61DTO> doCreateEntity(MyEntity61 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample61DTO> doUpdateEntity(MyEntity61 entity, MyExample61DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample61DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample61DTO> getActions() {
		return Actions.<MyExample61DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}