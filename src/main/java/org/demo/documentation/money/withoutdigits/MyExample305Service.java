package org.demo.documentation.money.withoutdigits;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample305Service extends VersionAwareResponseService<MyExample305DTO, MyEntity305> {

	private final MyEntity305Repository repository;

	public MyExample305Service(MyEntity305Repository repository) {
		super(MyExample305DTO.class, MyEntity305.class, null, MyExample305Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample305DTO> doCreateEntity(MyEntity305 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample305DTO> doUpdateEntity(MyEntity305 entity, MyExample305DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample305DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample305DTO> getActions() {
		return Actions.<MyExample305DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}