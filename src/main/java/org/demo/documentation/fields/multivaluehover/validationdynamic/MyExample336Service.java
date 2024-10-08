package org.demo.documentation.fields.multivaluehover.validationdynamic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample336Service extends VersionAwareResponseService<MyExample336DTO, MyEntity336> {

	private final MyEntity336Repository repository;


	public MyExample336Service(MyEntity336Repository repository) {
		super(MyExample336DTO.class, MyEntity336.class, null, MyExample336Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample336DTO> doCreateEntity(MyEntity336 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample336DTO> doUpdateEntity(MyEntity336 entity, MyExample336DTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample336DTO> getActions() {
		return Actions.<MyExample336DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}