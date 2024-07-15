package org.demo.documentation.fields.text.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample45Service extends VersionAwareResponseService<MyExample45DTO, MyEntity45> {

	private final MyEntity45Repository repository;

	public MyExample45Service(MyEntity45Repository repository) {
		super(MyExample45DTO.class, MyEntity45.class, null, MyExample45Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample45DTO> doCreateEntity(MyEntity45 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample45DTO> doUpdateEntity(MyEntity45 entity, MyExample45DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample45DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample45DTO> getActions() {
		return Actions.<MyExample45DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}