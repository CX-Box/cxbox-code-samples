package org.demo.documentation.dictionary.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample70Service extends VersionAwareResponseService<MyExample70DTO, MyEntity70> {

	private final MyEntity70Repository repository;

	public MyExample70Service(MyEntity70Repository repository) {
		super(MyExample70DTO.class, MyEntity70.class, null, MyExample70Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample70DTO> doCreateEntity(MyEntity70 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample70DTO> doUpdateEntity(MyEntity70 entity, MyExample70DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample70DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample70DTO> getActions() {
		return Actions.<MyExample70DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}