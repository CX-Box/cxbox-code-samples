package org.demo.documentation.money.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample62Service extends VersionAwareResponseService<MyExample62DTO, MyEntity62> {

	private final MyEntity62Repository repository;

	public MyExample62Service(MyEntity62Repository repository) {
		super(MyExample62DTO.class, MyEntity62.class, null, MyExample62Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample62DTO> doCreateEntity(MyEntity62 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample62DTO> doUpdateEntity(MyEntity62 entity, MyExample62DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample62DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample62DTO> getActions() {
		return Actions.<MyExample62DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}