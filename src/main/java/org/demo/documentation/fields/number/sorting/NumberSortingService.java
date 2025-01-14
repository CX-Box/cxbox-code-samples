package org.demo.documentation.fields.number.sorting;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class NumberSortingService extends VersionAwareResponseService<NumberSortingDTO, NumberSortingEntity> {

	private final NumberSortingEntityRepository repository;

	public NumberSortingService(NumberSortingEntityRepository repository) {
		super(NumberSortingDTO.class, NumberSortingEntity.class, null, NumberSortingMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberSortingDTO> doCreateEntity(NumberSortingEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberSortingDTO> doUpdateEntity(NumberSortingEntity entity, NumberSortingDTO data,
			BusinessComponent bc) {
		setIfChanged(data, NumberSortingDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberSortingDTO> getActions() {
		return Actions.<NumberSortingDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}