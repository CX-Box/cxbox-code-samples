package org.demo.documentation.picklist.colorconst;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample108Service extends VersionAwareResponseService<MyExample108DTO, MyEntity108> {

	private final MyEntity108Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample108Service(MyEntity108Repository repository) {
		super(MyExample108DTO.class, MyEntity108.class, null, MyExample108Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample108DTO> doCreateEntity(MyEntity108 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample108DTO> doUpdateEntity(MyEntity108 entity, MyExample108DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample108DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity122.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample108DTO> getActions() {
		return Actions.<MyExample108DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}