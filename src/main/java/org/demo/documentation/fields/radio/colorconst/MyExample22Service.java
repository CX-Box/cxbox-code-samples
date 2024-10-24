package org.demo.documentation.fields.radio.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample22Service extends VersionAwareResponseService<MyExample22DTO, MyEntity22> {

	private final MyEntity22Repository repository;

	public MyExample22Service(MyEntity22Repository repository) {
		super(MyExample22DTO.class, MyEntity22.class, null, MyExample22Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample22DTO> doCreateEntity(MyEntity22 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample22DTO> doUpdateEntity(MyEntity22 entity, MyExample22DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample22DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample22DTO> getActions() {
		return Actions.<MyExample22DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}