package org.demo.documentation.inlinepicklist.filtration;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.inlinepicklist.filtration.picklist.MyEntity143;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample142Service extends VersionAwareResponseService<MyExample142DTO, MyEntity142> {

	private final MyEntity142Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample142Service(MyEntity142Repository repository) {
		super(MyExample142DTO.class, MyEntity142.class, null, MyExample142Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample142DTO> doCreateEntity(MyEntity142 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample142DTO> doUpdateEntity(MyEntity142 entity, MyExample142DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample142DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity143.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample142DTO> getActions() {
		return Actions.<MyExample142DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}