package org.demo.documentation.multivaluehover.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample243Service extends VersionAwareResponseService<MyExample243DTO, MyEntity243> {

	private final MyEntity243Repository repository;

	public MyExample243Service(MyEntity243Repository repository) {
		super(MyExample243DTO.class, MyEntity243.class, null, MyExample243Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample243DTO> doCreateEntity(MyEntity243 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample243DTO> doUpdateEntity(MyEntity243 entity, MyExample243DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample243DTO> getActions() {
		return Actions.<MyExample243DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}