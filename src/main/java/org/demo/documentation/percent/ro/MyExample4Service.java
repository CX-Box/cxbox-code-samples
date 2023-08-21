package org.demo.documentation.percent.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4Service extends VersionAwareResponseService<MyExample4DTO, MyEntity4> {

	private final MyEntity4Repository repository;

	public MyExample4Service(MyEntity4Repository repository) {
		super(MyExample4DTO.class, MyEntity4.class, null, MyExample4Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample4DTO> doCreateEntity(MyEntity4 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4DTO> doUpdateEntity(MyEntity4 entity, MyExample4DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample4DTO> getActions() {
		return Actions.<MyExample4DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}