package org.demo.documentation.fields.inlinepicklist.colorconst;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.inlinepicklist.colorconst.picklist.MyEntity137;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample136Service extends VersionAwareResponseService<MyExample136DTO, MyEntity136> {

	private final MyEntity136Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample136Service(MyEntity136Repository repository) {
		super(MyExample136DTO.class, MyEntity136.class, null, MyExample136Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample136DTO> doCreateEntity(MyEntity136 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample136DTO> doUpdateEntity(MyEntity136 entity, MyExample136DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample136DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity137.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample136DTO> getActions() {
		return Actions.<MyExample136DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}