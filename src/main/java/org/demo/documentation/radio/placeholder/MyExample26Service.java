package org.demo.documentation.radio.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample26Service extends VersionAwareResponseService<MyExample26DTO, MyEntity26> {

	private final MyEntity26Repository repository;

	public MyExample26Service(MyEntity26Repository repository) {
		super(MyExample26DTO.class, MyEntity26.class, null, MyExample26Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample26DTO> doCreateEntity(MyEntity26 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample26DTO> doUpdateEntity(MyEntity26 entity, MyExample26DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample26DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample26DTO> getActions() {
		return Actions.<MyExample26DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}