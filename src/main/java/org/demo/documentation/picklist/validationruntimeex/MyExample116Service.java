package org.demo.documentation.picklist.validationruntimeex;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample116Service extends VersionAwareResponseService<MyExample116DTO, MyEntity116> {

	private final MyEntity116Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample116Service(MyEntity116Repository repository) {
		super(MyExample116DTO.class, MyEntity116.class, null, MyExample116Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample116DTO> doCreateEntity(MyEntity116 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample116DTO> doUpdateEntity(MyEntity116 entity, MyExample116DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample116DTO_.customFieldId)) {
			entity.setCustomFieldEntity(data.getCustomFieldId() != null
					? entityManager.getReference(MyEntity131.class, data.getCustomFieldId())
					: null);
			try {
				//call custom function
				throw new Exception("Error");
			} catch (Exception e) {
				throw new RuntimeException("An unexpected error has occurred.");
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample116DTO> getActions() {
		return Actions.<MyExample116DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}