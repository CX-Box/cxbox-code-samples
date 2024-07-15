package org.demo.documentation.fields.money.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample68Service extends VersionAwareResponseService<MyExample68DTO, MyEntity68> {

	private final MyEntity68Repository repository;

	public MyExample68Service(MyEntity68Repository repository) {
		super(MyExample68DTO.class, MyEntity68.class, null, MyExample68Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample68DTO> doCreateEntity(MyEntity68 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample68DTO> doUpdateEntity(MyEntity68 entity, MyExample68DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample68DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample68DTO> getActions() {
		return Actions.<MyExample68DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value ?"))
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}