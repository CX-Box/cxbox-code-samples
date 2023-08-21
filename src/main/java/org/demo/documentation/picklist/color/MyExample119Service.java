package org.demo.documentation.picklist.color;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample119Service extends VersionAwareResponseService<MyExample119DTO, MyEntity119> {

	private final MyEntity119Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample119Service(MyEntity119Repository repository) {
		super(MyExample119DTO.class, MyEntity119.class, null, MyExample119Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample119DTO> doCreateEntity(MyEntity119 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample119DTO> doUpdateEntity(MyEntity119 entity, MyExample119DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample119DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity121.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample119DTO> getActions() {
		return Actions.<MyExample119DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}