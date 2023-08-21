package org.demo.documentation.dictionary.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample88Service extends VersionAwareResponseService<MyExample88DTO, MyEntity88> {

	private final MyEntity88Repository repository;

	public MyExample88Service(MyEntity88Repository repository) {
		super(MyExample88DTO.class, MyEntity88.class, null, MyExample88Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample88DTO> doCreateEntity(MyEntity88 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample88DTO> doUpdateEntity(MyEntity88 entity, MyExample88DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample88DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample88DTO> getActions() {
		return Actions.<MyExample88DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}