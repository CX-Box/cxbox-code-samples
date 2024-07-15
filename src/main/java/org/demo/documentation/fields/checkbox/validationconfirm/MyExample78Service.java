package org.demo.documentation.fields.checkbox.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample78Service extends VersionAwareResponseService<MyExample78DTO, MyEntity78> {

	private final MyEntity78Repository repository;

	public MyExample78Service(MyEntity78Repository repository) {
		super(MyExample78DTO.class, MyEntity78.class, null, MyExample78Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample78DTO> doCreateEntity(MyEntity78 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample78DTO> doUpdateEntity(MyEntity78 entity, MyExample78DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample78DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample78DTO> getActions() {
		return Actions.<MyExample78DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value ?"))
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}