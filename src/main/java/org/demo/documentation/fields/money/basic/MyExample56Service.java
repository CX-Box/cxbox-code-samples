package org.demo.documentation.fields.money.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample56Service extends VersionAwareResponseService<MyExample56DTO, MyEntity56> {

	private final MyEntity56Repository repository;

	public MyExample56Service(MyEntity56Repository repository) {
		super(MyExample56DTO.class, MyEntity56.class, null, MyExample56Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample56DTO> doCreateEntity(MyEntity56 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]	// --8<-- [start:editable]
	@Override
	protected ActionResultDTO<MyExample56DTO> doUpdateEntity(MyEntity56 entity, MyExample56DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample56DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	// --8<-- [end:editable]

	@Override
	public Actions<MyExample56DTO> getActions() {
		return Actions.<MyExample56DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}