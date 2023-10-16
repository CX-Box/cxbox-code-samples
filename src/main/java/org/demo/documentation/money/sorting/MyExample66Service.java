package org.demo.documentation.money.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample66Service extends VersionAwareResponseService<MyExample66DTO, MyEntity66> {

	private final MyEntity66Repository repository;

	public MyExample66Service(MyEntity66Repository repository) {
		super(MyExample66DTO.class, MyEntity66.class, null, MyExample66Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample66DTO> doCreateEntity(MyEntity66 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample66DTO> doUpdateEntity(MyEntity66 entity, MyExample66DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample66DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample66DTO> getActions() {
		return Actions.<MyExample66DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}