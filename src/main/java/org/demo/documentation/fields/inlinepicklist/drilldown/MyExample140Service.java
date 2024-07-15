package org.demo.documentation.fields.inlinepicklist.drilldown;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.inlinepicklist.drilldown.picklist.MyEntity141;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample140Service extends VersionAwareResponseService<MyExample140DTO, MyEntity140> {

	private final MyEntity140Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample140Service(MyEntity140Repository repository) {
		super(MyExample140DTO.class, MyEntity140.class, null, MyExample140Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample140DTO> doCreateEntity(MyEntity140 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample140DTO> doUpdateEntity(MyEntity140 entity, MyExample140DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample140DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity141.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample140DTO> getActions() {
		return Actions.<MyExample140DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}