package org.demo.documentation.hint.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample156Service extends VersionAwareResponseService<MyExample156DTO, MyEntity156> {

	private final MyEntity156Repository repository;

	public MyExample156Service(MyEntity156Repository repository) {
		super(MyExample156DTO.class, MyEntity156.class, null, MyExample156Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample156DTO> doCreateEntity(MyEntity156 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample156DTO> doUpdateEntity(MyEntity156 entity, MyExample156DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample156DTO_.textField)) {
			entity.setTextField(data.getTextField());
		}
		if (data.isFieldChanged(MyExample156DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample156DTO> getActions() {
		return Actions.<MyExample156DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}