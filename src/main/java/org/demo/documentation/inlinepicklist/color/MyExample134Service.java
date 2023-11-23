package org.demo.documentation.inlinepicklist.color;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.inlinepicklist.color.picklist.MyEntity135;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample134Service extends VersionAwareResponseService<MyExample134DTO, MyEntity134> {

	private final MyEntity134Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample134Service(MyEntity134Repository repository) {
		super(MyExample134DTO.class, MyEntity134.class, null, MyExample134Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample134DTO> doCreateEntity(MyEntity134 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample134DTO> doUpdateEntity(MyEntity134 entity, MyExample134DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample134DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity135.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample134DTO> getActions() {
		return Actions.<MyExample134DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}