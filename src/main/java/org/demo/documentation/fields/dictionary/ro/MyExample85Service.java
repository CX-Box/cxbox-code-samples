package org.demo.documentation.fields.dictionary.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample85Service extends VersionAwareResponseService<MyExample85DTO, MyEntity85> {

	private final MyEntity85Repository repository;

	public MyExample85Service(MyEntity85Repository repository) {
		super(MyExample85DTO.class, MyEntity85.class, null, MyExample85Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample85DTO> doCreateEntity(MyEntity85 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample85DTO> doUpdateEntity(MyEntity85 entity, MyExample85DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample85DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample85DTO> getActions() {
		return Actions.<MyExample85DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}