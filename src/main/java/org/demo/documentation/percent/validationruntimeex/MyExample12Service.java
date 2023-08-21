package org.demo.documentation.percent.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample12Service extends VersionAwareResponseService<MyExample12DTO, MyEntity12> {

	private final MyEntity12Repository repository;

	public MyExample12Service(MyEntity12Repository repository) {
		super(MyExample12DTO.class, MyEntity12.class, null, MyExample12Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample12DTO> doCreateEntity(MyEntity12 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample12DTO> doUpdateEntity(MyEntity12 entity, MyExample12DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample12DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
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
	public Actions<MyExample12DTO> getActions() {
		return Actions.<MyExample12DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}