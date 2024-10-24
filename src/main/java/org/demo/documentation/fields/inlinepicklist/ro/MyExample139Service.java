package org.demo.documentation.fields.inlinepicklist.ro;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.inlinepicklist.ro.picklist.MyEntity138;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample139Service extends VersionAwareResponseService<MyExample139DTO, MyEntity139> {

	private final MyEntity139Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample139Service(MyEntity139Repository repository) {
		super(MyExample139DTO.class, MyEntity139.class, null, MyExample139Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample139DTO> doCreateEntity(MyEntity139 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample139DTO> doUpdateEntity(MyEntity139 entity, MyExample139DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample139DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity138.class, data.getCustomFieldId())
					: null);
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample139DTO> getActions() {
		return Actions.<MyExample139DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}