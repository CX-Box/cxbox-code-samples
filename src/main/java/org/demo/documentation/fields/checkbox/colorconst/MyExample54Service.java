package org.demo.documentation.fields.checkbox.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample54Service extends VersionAwareResponseService<MyExample54DTO, MyEntity54> {

	private final MyEntity54Repository repository;

	public MyExample54Service(MyEntity54Repository repository) {
		super(MyExample54DTO.class, MyEntity54.class, null, MyExample54Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample54DTO> doCreateEntity(MyEntity54 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample54DTO> doUpdateEntity(MyEntity54 entity, MyExample54DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample54DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample54DTO> getActions() {
		return Actions.<MyExample54DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}