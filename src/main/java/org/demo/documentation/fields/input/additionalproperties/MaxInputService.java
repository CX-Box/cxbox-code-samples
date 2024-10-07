package org.demo.documentation.fields.input.additionalproperties;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MaxInputService extends VersionAwareResponseService<MaxInputDTO, MaxInputEntity> {

	private final MaxInputEntityRepository repository;

	public MaxInputService(MaxInputEntityRepository repository) {
		super(MaxInputDTO.class, MaxInputEntity.class, null, MaxInputMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<MaxInputDTO> doCreateEntity(MaxInputEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MaxInputDTO> doUpdateEntity(MaxInputEntity entity, MaxInputDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MaxInputDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MaxInputDTO> getActions() {
		return Actions.<MaxInputDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}