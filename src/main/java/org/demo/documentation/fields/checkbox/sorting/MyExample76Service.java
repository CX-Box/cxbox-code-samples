package org.demo.documentation.fields.checkbox.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample76Service extends VersionAwareResponseService<MyExample76DTO, MyEntity76> {

	private final MyEntity76Repository repository;

	public MyExample76Service(MyEntity76Repository repository) {
		super(MyExample76DTO.class, MyEntity76.class, null, MyExample76Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample76DTO> doCreateEntity(MyEntity76 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample76DTO> doUpdateEntity(MyEntity76 entity, MyExample76DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample76DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample76DTO> getActions() {
		return Actions.<MyExample76DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}