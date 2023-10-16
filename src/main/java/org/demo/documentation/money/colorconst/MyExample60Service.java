package org.demo.documentation.money.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample60Service extends VersionAwareResponseService<MyExample60DTO, MyEntity60> {

	private final MyEntity60Repository repository;

	public MyExample60Service(MyEntity60Repository repository) {
		super(MyExample60DTO.class, MyEntity60.class, null, MyExample60Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample60DTO> doCreateEntity(MyEntity60 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample60DTO> doUpdateEntity(MyEntity60 entity, MyExample60DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample60DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample60DTO> getActions() {
		return Actions.<MyExample60DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}