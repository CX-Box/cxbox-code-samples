package org.demo.documentation.fields.checkbox.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample82Service extends VersionAwareResponseService<MyExample82DTO, MyEntity82> {

	private final MyEntity82Repository repository;

	public MyExample82Service(MyEntity82Repository repository) {
		super(MyExample82DTO.class, MyEntity82.class, null, MyExample82Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample82DTO> doCreateEntity(MyEntity82 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample82DTO> doUpdateEntity(MyEntity82 entity, MyExample82DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample82DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample82DTO> getActions() {
		return Actions.<MyExample82DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}