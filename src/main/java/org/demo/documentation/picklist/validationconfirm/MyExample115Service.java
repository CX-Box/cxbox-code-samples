package org.demo.documentation.picklist.validationconfirm;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample115Service extends VersionAwareResponseService<MyExample115DTO, MyEntity115> {

	private final MyEntity115Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample115Service(MyEntity115Repository repository) {
		super(MyExample115DTO.class, MyEntity115.class, null, MyExample115Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample115DTO> doCreateEntity(MyEntity115 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample115DTO> doUpdateEntity(MyEntity115 entity, MyExample115DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample115DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity130.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample115DTO> getActions() {
		return Actions.<MyExample115DTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value 'customField'?"))
				.add()
				.build();
	}

}