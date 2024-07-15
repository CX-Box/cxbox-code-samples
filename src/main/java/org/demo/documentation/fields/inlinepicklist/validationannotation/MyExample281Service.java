package org.demo.documentation.fields.inlinepicklist.validationannotation;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample281Service extends VersionAwareResponseService<MyExample281DTO, MyEntity281> {

	private final MyEntity281Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample281Service(MyEntity281Repository repository) {
		super(MyExample281DTO.class, MyEntity281.class, null, MyExample281Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample281DTO> doCreateEntity(MyEntity281 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample281DTO> doUpdateEntity(MyEntity281 entity, MyExample281DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample281DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity280.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample281DTO> getActions() {
		return Actions.<MyExample281DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}