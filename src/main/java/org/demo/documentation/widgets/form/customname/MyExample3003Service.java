package org.demo.documentation.widgets.form.customname;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3003Service extends VersionAwareResponseService<MyExample3003DTO, MyEntity3003> {

	private final MyEntity3003Repository repository;

	public MyExample3003Service(MyEntity3003Repository repository) {
		super(MyExample3003DTO.class, MyEntity3003.class, null, MyExample3003Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample3003DTO> doCreateEntity(MyEntity3003 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3003DTO> doUpdateEntity(MyEntity3003 entity, MyExample3003DTO data,
															   BusinessComponent bc) {
		if (data.isFieldChanged(MyExample3003DTO_.customTitleField)) {
			entity.setCustomTitleField(data.getCustomTitleField());
		}
		if (data.isFieldChanged(MyExample3003DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3003DTO> getActions() {
		return Actions.<MyExample3003DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}