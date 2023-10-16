package org.demo.documentation.radio.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample23Service extends VersionAwareResponseService<MyExample23DTO, MyEntity23> {

	private final MyEntity23Repository repository;

	public MyExample23Service(MyEntity23Repository repository) {
		super(MyExample23DTO.class, MyEntity23.class, null, MyExample23Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample23DTO> doCreateEntity(MyEntity23 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample23DTO> doUpdateEntity(MyEntity23 entity, MyExample23DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample23DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample23DTO> getActions() {
		return Actions.<MyExample23DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}