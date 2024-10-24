package org.demo.documentation.fields.percent.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample3Service extends VersionAwareResponseService<MyExample3DTO, MyEntity3> {

	private final MyEntity3Repository repository;

	public MyExample3Service(MyEntity3Repository repository) {
		super(MyExample3DTO.class, MyEntity3.class, null, MyExample3Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample3DTO> doCreateEntity(MyEntity3 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample3DTO> doUpdateEntity(MyEntity3 entity, MyExample3DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample3DTO> getActions() {
		return Actions.<MyExample3DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}