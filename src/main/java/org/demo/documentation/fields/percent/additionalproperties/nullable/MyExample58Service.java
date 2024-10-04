package org.demo.documentation.fields.percent.additionalproperties.nullable;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample58Service extends VersionAwareResponseService<MyExample58DTO, MyEntity58> {

	private final MyEntity58Repository repository;

	public MyExample58Service(MyEntity58Repository repository) {
		super(MyExample58DTO.class, MyEntity58.class, null, MyExample58Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample58DTO> doCreateEntity(MyEntity58 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample58DTO> doUpdateEntity(MyEntity58 entity, MyExample58DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample58DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample58DTO> getActions() {
		return Actions.<MyExample58DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}