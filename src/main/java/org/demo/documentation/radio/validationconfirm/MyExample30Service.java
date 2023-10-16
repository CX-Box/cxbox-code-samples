package org.demo.documentation.radio.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample30Service extends VersionAwareResponseService<MyExample30DTO, MyEntity30> {

	private final MyEntity30Repository repository;

	public MyExample30Service(MyEntity30Repository repository) {
		super(MyExample30DTO.class, MyEntity30.class, null, MyExample30Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample30DTO> doCreateEntity(MyEntity30 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample30DTO> doUpdateEntity(MyEntity30 entity, MyExample30DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample30DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample30DTO> getActions() {
		return Actions.<MyExample30DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value 'customField'?"))
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}