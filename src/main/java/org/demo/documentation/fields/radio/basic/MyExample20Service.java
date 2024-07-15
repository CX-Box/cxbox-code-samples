package org.demo.documentation.fields.radio.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample20Service extends VersionAwareResponseService<MyExample20DTO, MyEntity20> {

	private final MyEntity20Repository repository;

	public MyExample20Service(MyEntity20Repository repository) {
		super(MyExample20DTO.class, MyEntity20.class, null, MyExample20Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample20DTO> doCreateEntity(MyEntity20 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample20DTO> doUpdateEntity(MyEntity20 entity, MyExample20DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample20DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample20DTO> getActions() {
		return Actions.<MyExample20DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}