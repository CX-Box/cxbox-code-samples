package org.demo.documentation.picklist.filtration;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample111Service extends VersionAwareResponseService<MyExample111DTO, MyEntity111> {

	private final MyEntity111Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample111Service(MyEntity111Repository repository) {
		super(MyExample111DTO.class, MyEntity111.class, null, MyExample111Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample111DTO> doCreateEntity(MyEntity111 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample111DTO> doUpdateEntity(MyEntity111 entity, MyExample111DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample111DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity125.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample111DTO> getActions() {
		return Actions.<MyExample111DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}