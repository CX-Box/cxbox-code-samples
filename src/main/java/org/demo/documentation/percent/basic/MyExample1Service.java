package org.demo.documentation.percent.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample1Service extends VersionAwareResponseService<MyExample1DTO, MyEntity1> {

	private final MyEntity1Repository repository;

	public MyExample1Service(MyEntity1Repository repository) {
		super(MyExample1DTO.class, MyEntity1.class, null, MyExample1Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample1DTO> doCreateEntity(MyEntity1 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample1DTO> doUpdateEntity(MyEntity1 entity, MyExample1DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample1DTO> getActions() {
		return Actions.<MyExample1DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}