package org.demo.documentation.text.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample295Service extends VersionAwareResponseService<MyExample295DTO, MyEntity295> {

	private final MyEntity295Repository repository;

	public MyExample295Service(MyEntity295Repository repository) {
		super(MyExample295DTO.class, MyEntity295.class, null, MyExample295Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample295DTO> doCreateEntity(MyEntity295 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample295DTO> doUpdateEntity(MyEntity295 entity, MyExample295DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample295DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample295DTO> getActions() {
		return Actions.<MyExample295DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}