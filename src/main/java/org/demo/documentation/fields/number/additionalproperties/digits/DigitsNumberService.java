package org.demo.documentation.fields.number.additionalproperties.digits;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class DigitsNumberService extends VersionAwareResponseService<DigitsNumberDTO, DigitsNumberEntity> {

	private final DigitsNumberEntityRepository repository;

	public DigitsNumberService(DigitsNumberEntityRepository repository) {
		super(DigitsNumberDTO.class, DigitsNumberEntity.class, null, DigitsNumberMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DigitsNumberDTO> doCreateEntity(DigitsNumberEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DigitsNumberDTO> doUpdateEntity(DigitsNumberEntity entity, DigitsNumberDTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DigitsNumberDTO> getActions() {
		return Actions.<DigitsNumberDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}