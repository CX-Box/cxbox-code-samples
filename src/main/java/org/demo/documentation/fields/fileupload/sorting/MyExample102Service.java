package org.demo.documentation.fields.fileupload.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample102Service extends VersionAwareResponseService<MyExample102DTO, MyEntity102> {

	private final MyEntity102Repository repository;

	public MyExample102Service(MyEntity102Repository repository) {
		super(MyExample102DTO.class, MyEntity102.class, null, MyExample102Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample102DTO> doCreateEntity(MyEntity102 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample102DTO> doUpdateEntity(MyEntity102 entity, MyExample102DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample102DTO_.customFieldId)) {
			entity.setCustomFieldId(data.getCustomFieldId());
		}
		if (data.isFieldChanged(MyExample102DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample102DTO> getActions() {
		return Actions.<MyExample102DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}