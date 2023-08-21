package org.demo.documentation.number.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample290Service extends VersionAwareResponseService<MyExample290DTO, MyEntity290> {

	private final MyEntity290Repository repository;

	public MyExample290Service(MyEntity290Repository repository) {
		super(MyExample290DTO.class, MyEntity290.class, null, MyExample290Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample290DTO> doCreateEntity(MyEntity290 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample290DTO> doUpdateEntity(MyEntity290 entity, MyExample290DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample290DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample290DTO> getActions() {
		return Actions.<MyExample290DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}