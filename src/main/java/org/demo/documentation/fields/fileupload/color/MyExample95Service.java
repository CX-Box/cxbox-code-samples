package org.demo.documentation.fields.fileupload.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample95Service extends VersionAwareResponseService<MyExample95DTO, MyEntity95> {

	private final MyEntity95Repository repository;

	public MyExample95Service(MyEntity95Repository repository) {
		super(MyExample95DTO.class, MyEntity95.class, null, MyExample95Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample95DTO> doCreateEntity(MyEntity95 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample95DTO> doUpdateEntity(MyEntity95 entity, MyExample95DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample95DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample95DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample95DTO> getActions() {
		return Actions.<MyExample95DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}