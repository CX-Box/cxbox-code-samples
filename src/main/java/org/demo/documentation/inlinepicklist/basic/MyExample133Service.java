package org.demo.documentation.inlinepicklist.basic;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.inlinepicklist.basic.picklist.MyEntity132;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample133Service extends VersionAwareResponseService<MyExample133DTO, MyEntity133> {

	private final MyEntity133Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample133Service(MyEntity133Repository repository) {
		super(MyExample133DTO.class, MyEntity133.class, null, MyExample133Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample133DTO> doCreateEntity(MyEntity133 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample133DTO> doUpdateEntity(MyEntity133 entity, MyExample133DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample133DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity132.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample133DTO> getActions() {
		return Actions.<MyExample133DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}