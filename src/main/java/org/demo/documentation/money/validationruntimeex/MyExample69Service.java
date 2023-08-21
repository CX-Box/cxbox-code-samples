package org.demo.documentation.money.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample69Service extends VersionAwareResponseService<MyExample69DTO, MyEntity69> {

	private final MyEntity69Repository repository;

	public MyExample69Service(MyEntity69Repository repository) {
		super(MyExample69DTO.class, MyEntity69.class, null, MyExample69Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample69DTO> doCreateEntity(MyEntity69 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample69DTO> doUpdateEntity(MyEntity69 entity, MyExample69DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample69DTO_.customField)) {
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
	public Actions<MyExample69DTO> getActions() {
		return Actions.<MyExample69DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}