package org.demo.documentation.dictionary.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample93Service extends VersionAwareResponseService<MyExample93DTO, MyEntity93> {

	private final MyEntity93Repository repository;

	public MyExample93Service(MyEntity93Repository repository) {
		super(MyExample93DTO.class, MyEntity93.class, null, MyExample93Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample93DTO> doCreateEntity(MyEntity93 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample93DTO> doUpdateEntity(MyEntity93 entity, MyExample93DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample93DTO_.customField)) {
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
	public Actions<MyExample93DTO> getActions() {
		return Actions.<MyExample93DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}