package org.demo.documentation.widgets.info;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3001Service extends VersionAwareResponseService<MyExample3001DTO, MyEntity3001> {

	private final MyEntity3001Repository repository;

	public MyExample3001Service(MyEntity3001Repository repository) {
		super(MyExample3001DTO.class, MyEntity3001.class, null, MyExample3001Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample3001DTO> doCreateEntity(MyEntity3001 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3001DTO> doUpdateEntity(MyEntity3001 entity, MyExample3001DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3001DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3001DTO> getActions() {
		return Actions.<MyExample3001DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}