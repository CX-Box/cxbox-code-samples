package org.demo.documentation.percent.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample73Service extends VersionAwareResponseService<MyExample73DTO, MyEntity73> {

	private final MyEntity73Repository repository;

	public MyExample73Service(MyEntity73Repository repository) {
		super(MyExample73DTO.class, MyEntity73.class, null, MyExample73Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample73DTO> doCreateEntity(MyEntity73 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample73DTO> doUpdateEntity(MyEntity73 entity, MyExample73DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample73DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample73DTO> getActions() {
		return Actions.<MyExample73DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}