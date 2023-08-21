package org.demo.documentation.multivaluehover.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample245Service extends VersionAwareResponseService<MyExample245DTO, MyEntity245> {

	private final MyEntity245Repository repository;

	public MyExample245Service(MyEntity245Repository repository) {
		super(MyExample245DTO.class, MyEntity245.class, null, MyExample245Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample245DTO> doCreateEntity(MyEntity245 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample245DTO> doUpdateEntity(MyEntity245 entity, MyExample245DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample245DTO> getActions() {
		return Actions.<MyExample245DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}