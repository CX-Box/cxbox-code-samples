package org.demo.documentation.picklist.drilldown;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample110Service extends VersionAwareResponseService<MyExample110DTO, MyEntity110> {

	private final MyEntity110Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample110Service(MyEntity110Repository repository) {
		super(MyExample110DTO.class, MyEntity110.class, null, MyExample110Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample110DTO> doCreateEntity(MyEntity110 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample110DTO> doUpdateEntity(MyEntity110 entity, MyExample110DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample110DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity124.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample110DTO> getActions() {
		return Actions.<MyExample110DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}