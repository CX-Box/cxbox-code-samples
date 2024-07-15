package org.demo.documentation.fields.radio.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample24Service extends VersionAwareResponseService<MyExample24DTO, MyEntity24> {

	private final MyEntity24Repository repository;

	public MyExample24Service(MyEntity24Repository repository) {
		super(MyExample24DTO.class, MyEntity24.class, null, MyExample24Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample24DTO> doCreateEntity(MyEntity24 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample24DTO> doUpdateEntity(MyEntity24 entity, MyExample24DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample24DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample24DTO> getActions() {
		return Actions.<MyExample24DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}