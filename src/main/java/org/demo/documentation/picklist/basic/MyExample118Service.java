package org.demo.documentation.picklist.basic;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample118Service extends VersionAwareResponseService<MyExample118DTO, MyEntity118> {

	private final MyEntity118Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample118Service(MyEntity118Repository repository) {
		super(MyExample118DTO.class, MyEntity118.class, null, MyExample118Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample118DTO> doCreateEntity(MyEntity118 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample118DTO> doUpdateEntity(MyEntity118 entity, MyExample118DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample118DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity120.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample118DTO> getActions() {
		return Actions.<MyExample118DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}