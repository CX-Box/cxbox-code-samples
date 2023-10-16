package org.demo.documentation.number.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class NumberConfirmService extends VersionAwareResponseService<NumberConfirmDTO, NumberConfirmEntity> {

	private final NumberConfirmEntityRepository repository;

	public NumberConfirmService(NumberConfirmEntityRepository repository) {
		super(NumberConfirmDTO.class, NumberConfirmEntity.class, null, NumberConfirmMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberConfirmDTO> doCreateEntity(NumberConfirmEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberConfirmDTO> doUpdateEntity(NumberConfirmEntity entity, NumberConfirmDTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberConfirmDTO> getActions() {
		return Actions.<NumberConfirmDTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value 'customField'?"))
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}