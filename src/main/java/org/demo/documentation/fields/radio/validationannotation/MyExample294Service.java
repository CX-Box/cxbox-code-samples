package org.demo.documentation.fields.radio.validationannotation;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample294Service extends VersionAwareResponseService<MyExample294DTO, MyEntity294> {

	private final MyEntity294Repository repository;

	public MyExample294Service(MyEntity294Repository repository) {
		super(MyExample294DTO.class, MyEntity294.class, null, MyExample294Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample294DTO> doCreateEntity(MyEntity294 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample294DTO> doUpdateEntity(MyEntity294 entity, MyExample294DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample294DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample294DTO> getActions() {
		return Actions.<MyExample294DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}