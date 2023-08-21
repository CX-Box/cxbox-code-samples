package org.demo.documentation.text.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample48Service extends VersionAwareResponseService<MyExample48DTO, MyEntity48> {

	private final MyEntity48Repository repository;

	public MyExample48Service(MyEntity48Repository repository) {
		super(MyExample48DTO.class, MyEntity48.class, null, MyExample48Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample48DTO> doCreateEntity(MyEntity48 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample48DTO> doUpdateEntity(MyEntity48 entity, MyExample48DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample48DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample48DTO> getActions() {
		return Actions.<MyExample48DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}