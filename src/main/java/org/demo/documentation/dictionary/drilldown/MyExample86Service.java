package org.demo.documentation.dictionary.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample86Service extends VersionAwareResponseService<MyExample86DTO, MyEntity86> {

	private final MyEntity86Repository repository;

	public MyExample86Service(MyEntity86Repository repository) {
		super(MyExample86DTO.class, MyEntity86.class, null, MyExample86Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample86DTO> doCreateEntity(MyEntity86 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample86DTO> doUpdateEntity(MyEntity86 entity, MyExample86DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample86DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample86DTO> getActions() {
		return Actions.<MyExample86DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}