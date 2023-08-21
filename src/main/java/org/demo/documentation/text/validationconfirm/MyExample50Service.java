package org.demo.documentation.text.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample50Service extends VersionAwareResponseService<MyExample50DTO, MyEntity50> {

	private final MyEntity50Repository repository;

	public MyExample50Service(MyEntity50Repository repository) {
		super(MyExample50DTO.class, MyEntity50.class, null, MyExample50Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample50DTO> doCreateEntity(MyEntity50 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample50DTO> doUpdateEntity(MyEntity50 entity, MyExample50DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample50DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample50DTO> getActions() {
		return Actions.<MyExample50DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value 'customField'?"))
				.add()
				.build();
	}

}