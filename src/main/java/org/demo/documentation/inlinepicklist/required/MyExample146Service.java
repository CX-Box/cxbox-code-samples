package org.demo.documentation.inlinepicklist.required;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.inlinepicklist.required.picklist.MyEntity147;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample146Service extends VersionAwareResponseService<MyExample146DTO, MyEntity146> {

	private final MyEntity146Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample146Service(MyEntity146Repository repository) {
		super(MyExample146DTO.class, MyEntity146.class, null, MyExample146Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample146DTO> doCreateEntity(MyEntity146 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample146DTO> doUpdateEntity(MyEntity146 entity, MyExample146DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample146DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity147.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample146DTO> getActions() {
		return Actions.<MyExample146DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}