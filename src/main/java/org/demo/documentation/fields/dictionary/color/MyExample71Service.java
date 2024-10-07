package org.demo.documentation.fields.dictionary.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample71Service extends VersionAwareResponseService<MyExample71DTO, MyEntity71> {

	private final MyEntity71Repository repository;

	public MyExample71Service(MyEntity71Repository repository) {
		super(MyExample71DTO.class, MyEntity71.class, null, MyExample71Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample71DTO> doCreateEntity(MyEntity71 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample71DTO> doUpdateEntity(MyEntity71 entity, MyExample71DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample71DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample71DTO> getActions() {
		return Actions.<MyExample71DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}