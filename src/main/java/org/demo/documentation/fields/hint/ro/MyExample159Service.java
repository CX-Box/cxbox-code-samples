package org.demo.documentation.fields.hint.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample159Service extends VersionAwareResponseService<MyExample159DTO, MyEntity159> {

	private final MyEntity159Repository repository;

	public MyExample159Service(MyEntity159Repository repository) {
		super(MyExample159DTO.class, MyEntity159.class, null, MyExample159Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample159DTO> doCreateEntity(MyEntity159 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample159DTO> doUpdateEntity(MyEntity159 entity, MyExample159DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample159DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample159DTO> getActions() {
		return Actions.<MyExample159DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}