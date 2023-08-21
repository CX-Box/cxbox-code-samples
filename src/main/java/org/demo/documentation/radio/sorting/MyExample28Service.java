package org.demo.documentation.radio.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample28Service extends VersionAwareResponseService<MyExample28DTO, MyEntity28> {

	private final MyEntity28Repository repository;

	public MyExample28Service(MyEntity28Repository repository) {
		super(MyExample28DTO.class, MyEntity28.class, null, MyExample28Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample28DTO> doCreateEntity(MyEntity28 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample28DTO> doUpdateEntity(MyEntity28 entity, MyExample28DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample28DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample28DTO> getActions() {
		return Actions.<MyExample28DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}