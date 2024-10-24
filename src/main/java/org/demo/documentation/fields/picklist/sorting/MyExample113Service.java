package org.demo.documentation.fields.picklist.sorting;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample113Service extends VersionAwareResponseService<MyExample113DTO, MyEntity113> {

	private final MyEntity113Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample113Service(MyEntity113Repository repository) {
		super(MyExample113DTO.class, MyEntity113.class, null, MyExample113Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample113DTO> doCreateEntity(MyEntity113 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample113DTO> doUpdateEntity(MyEntity113 entity, MyExample113DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample113DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity128.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample113DTO> getActions() {
		return Actions.<MyExample113DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}