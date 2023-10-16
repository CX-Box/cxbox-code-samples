package org.demo.documentation.checkbox.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample80Service extends VersionAwareResponseService<MyExample80DTO, MyEntity80> {

	private final MyEntity80Repository repository;

	public MyExample80Service(MyEntity80Repository repository) {
		super(MyExample80DTO.class, MyEntity80.class, null, MyExample80Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample80DTO> doCreateEntity(MyEntity80 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample80DTO> doUpdateEntity(MyEntity80 entity, MyExample80DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample80DTO_.customField)) {
			try {
				//call custom function
				throw new Exception("Error");
			} catch (Exception e) {
				throw new RuntimeException("An unexpected error has occurred.");
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample80DTO> getActions() {
		return Actions.<MyExample80DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}