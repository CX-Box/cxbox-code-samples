package org.demo.documentation.number.validationbusinessex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class NumberBusinessExService extends VersionAwareResponseService<NumberBusinessExDTO, NumberBusinessExEntity> {

	private final NumberBusinessExEntityRepository repository;

	public NumberBusinessExService(NumberBusinessExEntityRepository repository) {
		super(NumberBusinessExDTO.class, NumberBusinessExEntity.class, null, NumberBusinessExMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberBusinessExDTO> doCreateEntity(NumberBusinessExEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberBusinessExDTO> doUpdateEntity(NumberBusinessExEntity entity, NumberBusinessExDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(NumberBusinessExDTO_.customField)) {
			if (data.getCustomField() < 20000) {
				throw new BusinessException().addPopup("The field 'customField' cannot be less than 20 000.");
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberBusinessExDTO> getActions() {
		return Actions.<NumberBusinessExDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}