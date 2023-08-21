package org.demo.documentation.inlinepicklist.validationruntimeex;

import javax.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MyExample154Service extends VersionAwareResponseService<MyExample154DTO, MyEntity154> {

	private final MyEntity154Repository repository;

	@Autowired
	private EntityManager entityManager;

	public MyExample154Service(MyEntity154Repository repository) {
		super(MyExample154DTO.class, MyEntity154.class, null, MyExample154Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample154DTO> doCreateEntity(MyEntity154 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample154DTO> doUpdateEntity(MyEntity154 entity, MyExample154DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample154DTO_.customFieldId)) {
			try {
				//call custom function
				throw new Exception("Error");
			} catch (Exception e) {
				throw new RuntimeException("An unexpected error has occurred.");
			}
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample154DTO> getActions() {
		return Actions.<MyExample154DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}