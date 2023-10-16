package org.demo.documentation.inlinepicklist.sorting;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample148Service extends VersionAwareResponseService<MyExample148DTO, MyEntity148> {

	private final MyEntity148Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample148Service(MyEntity148Repository repository) {
		super(MyExample148DTO.class, MyEntity148.class, null, MyExample148Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample148DTO> doCreateEntity(MyEntity148 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample148DTO> doUpdateEntity(MyEntity148 entity, MyExample148DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample148DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity149.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample148DTO> getActions() {
		return Actions.<MyExample148DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}