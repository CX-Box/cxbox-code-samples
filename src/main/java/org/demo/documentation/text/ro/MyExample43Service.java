package org.demo.documentation.text.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample43Service extends VersionAwareResponseService<MyExample43DTO, MyEntity43> {

	private final MyEntity43Repository repository;

	public MyExample43Service(MyEntity43Repository repository) {
		super(MyExample43DTO.class, MyEntity43.class, null, MyExample43Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample43DTO> doCreateEntity(MyEntity43 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample43DTO> doUpdateEntity(MyEntity43 entity, MyExample43DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample43DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample43DTO> getActions() {
		return Actions.<MyExample43DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}