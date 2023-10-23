package org.demo.documentation.widgets.list;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3002Service extends VersionAwareResponseService<MyExample3002DTO, MyEntity3002> {

	private final MyEntity3002Repository repository;

	public MyExample3002Service(MyEntity3002Repository repository) {
		super(MyExample3002DTO.class, MyEntity3002.class, null, MyExample3002Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample3002DTO> doCreateEntity(MyEntity3002 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3002DTO> doUpdateEntity(MyEntity3002 entity, MyExample3002DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3002DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3002DTO> getActions() {
		return Actions.<MyExample3002DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}