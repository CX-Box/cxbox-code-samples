package org.demo.documentation.picklist.ro;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample109Service extends VersionAwareResponseService<MyExample109DTO, MyEntity109> {

	private final MyEntity109Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample109Service(MyEntity109Repository repository) {
		super(MyExample109DTO.class, MyEntity109.class, null, MyExample109Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample109DTO> doCreateEntity(MyEntity109 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample109DTO> doUpdateEntity(MyEntity109 entity, MyExample109DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample109DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity123.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample109DTO> getActions() {
		return Actions.<MyExample109DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}