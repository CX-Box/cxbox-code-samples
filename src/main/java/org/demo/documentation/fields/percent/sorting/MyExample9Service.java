package org.demo.documentation.fields.percent.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample9Service extends VersionAwareResponseService<MyExample9DTO, MyEntity9> {

	private final MyEntity9Repository repository;

	public MyExample9Service(MyEntity9Repository repository) {
		super(MyExample9DTO.class, MyEntity9.class, null, MyExample9Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample9DTO> doCreateEntity(MyEntity9 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample9DTO> doUpdateEntity(MyEntity9 entity, MyExample9DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample9DTO> getActions() {
		return Actions.<MyExample9DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}