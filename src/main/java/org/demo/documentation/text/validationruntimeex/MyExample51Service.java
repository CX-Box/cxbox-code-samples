package org.demo.documentation.text.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample51Service extends VersionAwareResponseService<MyExample51DTO, MyEntity51> {

	private final MyEntity51Repository repository;

	public MyExample51Service(MyEntity51Repository repository) {
		super(MyExample51DTO.class, MyEntity51.class, null, MyExample51Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample51DTO> doCreateEntity(MyEntity51 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample51DTO> doUpdateEntity(MyEntity51 entity, MyExample51DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample51DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
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
	public Actions<MyExample51DTO> getActions() {
		return Actions.<MyExample51DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}