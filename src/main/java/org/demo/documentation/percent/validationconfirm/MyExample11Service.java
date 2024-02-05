package org.demo.documentation.percent.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample11Service extends VersionAwareResponseService<MyExample11DTO, MyEntity11> {

	private final MyEntity11Repository repository;

	public MyExample11Service(MyEntity11Repository repository) {
		super(MyExample11DTO.class, MyEntity11.class, null, MyExample11Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample11DTO> doCreateEntity(MyEntity11 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample11DTO> doUpdateEntity(MyEntity11 entity, MyExample11DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample11DTO> getActions() {
		return Actions.<MyExample11DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value ?"))
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}