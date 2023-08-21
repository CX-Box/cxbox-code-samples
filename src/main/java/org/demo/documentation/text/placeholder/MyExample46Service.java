package org.demo.documentation.text.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample46Service extends VersionAwareResponseService<MyExample46DTO, MyEntity46> {

	private final MyEntity46Repository repository;

	public MyExample46Service(MyEntity46Repository repository) {
		super(MyExample46DTO.class, MyEntity46.class, null, MyExample46Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample46DTO> doCreateEntity(MyEntity46 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample46DTO> doUpdateEntity(MyEntity46 entity, MyExample46DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample46DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample46DTO> getActions() {
		return Actions.<MyExample46DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}