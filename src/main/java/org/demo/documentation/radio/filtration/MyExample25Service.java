package org.demo.documentation.radio.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample25Service extends VersionAwareResponseService<MyExample25DTO, MyEntity25> {

	private final MyEntity25Repository repository;

	public MyExample25Service(MyEntity25Repository repository) {
		super(MyExample25DTO.class, MyEntity25.class, null, MyExample25Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample25DTO> doCreateEntity(MyEntity25 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample25DTO> doUpdateEntity(MyEntity25 entity, MyExample25DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample25DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample25DTO> getActions() {
		return Actions.<MyExample25DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}