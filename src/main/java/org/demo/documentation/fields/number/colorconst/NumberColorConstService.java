package org.demo.documentation.fields.number.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class NumberColorConstService extends VersionAwareResponseService<NumberColorConstDTO, NumberColorConstEntity> {

	private final NumberColorConstEntityRepository repository;

	public NumberColorConstService(NumberColorConstEntityRepository repository) {
		super(NumberColorConstDTO.class, NumberColorConstEntity.class, null, NumberColorConstMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberColorConstDTO> doCreateEntity(NumberColorConstEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberColorConstDTO> doUpdateEntity(NumberColorConstEntity entity, NumberColorConstDTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberColorConstDTO> getActions() {
		return Actions.<NumberColorConstDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}