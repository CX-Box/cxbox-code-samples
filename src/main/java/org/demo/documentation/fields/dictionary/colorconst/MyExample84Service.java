package org.demo.documentation.fields.dictionary.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample84Service extends VersionAwareResponseService<MyExample84DTO, MyEntity84> {

	private final MyEntity84Repository repository;

	public MyExample84Service(MyEntity84Repository repository) {
		super(MyExample84DTO.class, MyEntity84.class, null, MyExample84Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample84DTO> doCreateEntity(MyEntity84 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample84DTO> doUpdateEntity(MyEntity84 entity, MyExample84DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample84DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample84DTO> getActions() {
		return Actions.<MyExample84DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}