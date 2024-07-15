package org.demo.documentation.fields.radio.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample31Service extends VersionAwareResponseService<MyExample31DTO, MyEntity31> {

	private final MyEntity31Repository repository;

	public MyExample31Service(MyEntity31Repository repository) {
		super(MyExample31DTO.class, MyEntity31.class, null, MyExample31Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample31DTO> doCreateEntity(MyEntity31 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample31DTO> doUpdateEntity(MyEntity31 entity, MyExample31DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample31DTO_.customField)) {
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
	public Actions<MyExample31DTO> getActions() {
		return Actions.<MyExample31DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}