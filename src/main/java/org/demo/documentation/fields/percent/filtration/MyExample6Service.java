package org.demo.documentation.fields.percent.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample6Service extends VersionAwareResponseService<MyExample6DTO, MyEntity6> {

	private final MyEntity6Repository repository;

	public MyExample6Service(MyEntity6Repository repository) {
		super(MyExample6DTO.class, MyEntity6.class, null, MyExample6Meta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MyExample6DTO> doCreateEntity(MyEntity6 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MyExample6DTO> doUpdateEntity(MyEntity6 entity, MyExample6DTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample6DTO> getActions() {
		return Actions.<MyExample6DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]

}