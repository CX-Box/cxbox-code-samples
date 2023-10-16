package org.demo.documentation.number.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class NumberDrillDownService extends VersionAwareResponseService<NumberDrillDownDTO, NumberDrillDownEntity> {

	private final NumberDrillDownEntityRepository repository;

	public NumberDrillDownService(NumberDrillDownEntityRepository repository) {
		super(NumberDrillDownDTO.class, NumberDrillDownEntity.class, null, NumberDrillDownMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberDrillDownDTO> doCreateEntity(NumberDrillDownEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberDrillDownDTO> doUpdateEntity(NumberDrillDownEntity entity, NumberDrillDownDTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberDrillDownDTO> getActions() {
		return Actions.<NumberDrillDownDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}