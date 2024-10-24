package org.demo.documentation.fields.checkbox.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample79Service extends VersionAwareResponseService<MyExample79DTO, MyEntity79> {

	private final MyEntity79Repository repository;

	public MyExample79Service(MyEntity79Repository repository) {
		super(MyExample79DTO.class, MyEntity79.class, null, MyExample79Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample79DTO> doCreateEntity(MyEntity79 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample79DTO> doUpdateEntity(MyEntity79 entity, MyExample79DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample79DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample79DTO> getActions() {
		return Actions.<MyExample79DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}