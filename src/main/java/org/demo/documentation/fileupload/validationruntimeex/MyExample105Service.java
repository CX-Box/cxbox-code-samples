package org.demo.documentation.fileupload.validationruntimeex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample105Service extends VersionAwareResponseService<MyExample105DTO, MyEntity105> {

	private final MyEntity105Repository repository;

	public MyExample105Service(MyEntity105Repository repository) {
		super(MyExample105DTO.class, MyEntity105.class, null, MyExample105Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample105DTO> doCreateEntity(MyEntity105 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample105DTO> doUpdateEntity(MyEntity105 entity, MyExample105DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample105DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample105DTO_.customField)) {
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
	public Actions<MyExample105DTO> getActions() {
		return Actions.<MyExample105DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}