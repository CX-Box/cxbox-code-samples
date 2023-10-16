package org.demo.documentation.picklist.validationannotation;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample296Service extends VersionAwareResponseService<MyExample296DTO, MyEntity296> {

	private final MyEntity296Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample296Service(MyEntity296Repository repository) {
		super(MyExample296DTO.class, MyEntity296.class, null, MyExample296Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample296DTO> doCreateEntity(MyEntity296 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample296DTO> doUpdateEntity(MyEntity296 entity, MyExample296DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample296DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity297.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample296DTO> getActions() {
		return Actions.<MyExample296DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}