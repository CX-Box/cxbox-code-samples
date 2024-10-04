package org.demo.documentation.fields.dictionary.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample87Service extends VersionAwareResponseService<MyExample87DTO, MyEntity87> {

	private final MyEntity87Repository repository;

	public MyExample87Service(MyEntity87Repository repository) {
		super(MyExample87DTO.class, MyEntity87.class, null, MyExample87Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample87DTO> doCreateEntity(MyEntity87 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample87DTO> doUpdateEntity(MyEntity87 entity, MyExample87DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample87DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample87DTO> getActions() {
		return Actions.<MyExample87DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}