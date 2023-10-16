package org.demo.documentation.input.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample163Service extends VersionAwareResponseService<MyExample163DTO, MyEntity163> {

	private final MyEntity163Repository repository;

	public MyExample163Service(MyEntity163Repository repository) {
		super(MyExample163DTO.class, MyEntity163.class, null, MyExample163Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample163DTO> doCreateEntity(MyEntity163 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample163DTO> doUpdateEntity(MyEntity163 entity, MyExample163DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample163DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample163DTO> getActions() {
		return Actions.<MyExample163DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}