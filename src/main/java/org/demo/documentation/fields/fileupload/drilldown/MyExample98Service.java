package org.demo.documentation.fields.fileupload.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample98Service extends VersionAwareResponseService<MyExample98DTO, MyEntity98> {

	private final MyEntity98Repository repository;

	public MyExample98Service(MyEntity98Repository repository) {
		super(MyExample98DTO.class, MyEntity98.class, null, MyExample98Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample98DTO> doCreateEntity(MyEntity98 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample98DTO> doUpdateEntity(MyEntity98 entity, MyExample98DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample98DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample98DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample98DTO> getActions() {
		return Actions.<MyExample98DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]

}