package org.demo.documentation.picklist.placeholder;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample117Service extends VersionAwareResponseService<MyExample117DTO, MyEntity117> {

	private final MyEntity117Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample117Service(MyEntity117Repository repository) {
		super(MyExample117DTO.class, MyEntity117.class, null, MyExample117Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample117DTO> doCreateEntity(MyEntity117 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample117DTO> doUpdateEntity(MyEntity117 entity, MyExample117DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample117DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity126.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample117DTO> getActions() {
		return Actions.<MyExample117DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}