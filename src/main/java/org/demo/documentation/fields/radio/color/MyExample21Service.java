package org.demo.documentation.fields.radio.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample21Service extends VersionAwareResponseService<MyExample21DTO, MyEntity21> {

	private final MyEntity21Repository repository;

	public MyExample21Service(MyEntity21Repository repository) {
		super(MyExample21DTO.class, MyEntity21.class, null, MyExample21Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample21DTO> doCreateEntity(MyEntity21 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample21DTO> doUpdateEntity(MyEntity21 entity, MyExample21DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample21DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample21DTO> getActions() {
		return Actions.<MyExample21DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}