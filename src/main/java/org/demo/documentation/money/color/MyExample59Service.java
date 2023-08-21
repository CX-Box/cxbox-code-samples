package org.demo.documentation.money.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample59Service extends VersionAwareResponseService<MyExample59DTO, MyEntity59> {

	private final MyEntity59Repository repository;

	public MyExample59Service(MyEntity59Repository repository) {
		super(MyExample59DTO.class, MyEntity59.class, null, MyExample59Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample59DTO> doCreateEntity(MyEntity59 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample59DTO> doUpdateEntity(MyEntity59 entity, MyExample59DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample59DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample59DTO> getActions() {
		return Actions.<MyExample59DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}