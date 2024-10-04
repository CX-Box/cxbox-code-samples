package org.demo.documentation.fields.picklist.required;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample112Service extends VersionAwareResponseService<MyExample112DTO, MyEntity112> {

	private final MyEntity112Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample112Service(MyEntity112Repository repository) {
		super(MyExample112DTO.class, MyEntity112.class, null, MyExample112Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample112DTO> doCreateEntity(MyEntity112 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample112DTO> doUpdateEntity(MyEntity112 entity, MyExample112DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample112DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity127.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample112DTO> getActions() {
		return Actions.<MyExample112DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}