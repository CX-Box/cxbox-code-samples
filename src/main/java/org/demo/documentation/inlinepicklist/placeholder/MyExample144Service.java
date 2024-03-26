package org.demo.documentation.inlinepicklist.placeholder;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.inlinepicklist.placeholder.picklist.MyEntity145;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample144Service extends VersionAwareResponseService<MyExample144DTO, MyEntity144> {

	private final MyEntity144Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample144Service(MyEntity144Repository repository) {
		super(MyExample144DTO.class, MyEntity144.class, null, MyExample144Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample144DTO> doCreateEntity(MyEntity144 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample144DTO> doUpdateEntity(MyEntity144 entity, MyExample144DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample144DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity145.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample144DTO> getActions() {
		return Actions.<MyExample144DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}