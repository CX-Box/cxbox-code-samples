package org.demo.documentation.money.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample65Service extends VersionAwareResponseService<MyExample65DTO, MyEntity65> {

	private final MyEntity65Repository repository;

	public MyExample65Service(MyEntity65Repository repository) {
		super(MyExample65DTO.class, MyEntity65.class, null, MyExample65Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample65DTO> doCreateEntity(MyEntity65 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample65DTO> doUpdateEntity(MyEntity65 entity, MyExample65DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample65DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample65DTO> getActions() {
		return Actions.<MyExample65DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}