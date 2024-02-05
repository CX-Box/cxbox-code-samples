package org.demo.documentation.dictionary.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample92Service extends VersionAwareResponseService<MyExample92DTO, MyEntity92> {

	private final MyEntity92Repository repository;

	public MyExample92Service(MyEntity92Repository repository) {
		super(MyExample92DTO.class, MyEntity92.class, null, MyExample92Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample92DTO> doCreateEntity(MyEntity92 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample92DTO> doUpdateEntity(MyEntity92 entity, MyExample92DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample92DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample92DTO> getActions() {
		return Actions.<MyExample92DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value ?"))
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}