package org.demo.documentation.number.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class NumberCreateEditService extends VersionAwareResponseService<NumberCreateEditDTO, NumberCreateEditEntity> {

	private final NumberCreateEditEntityRepository repository;

	public NumberCreateEditService(NumberCreateEditEntityRepository repository) {
		super(NumberCreateEditDTO.class, NumberCreateEditEntity.class, null, NumberCreateEditMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberCreateEditDTO> doCreateEntity(NumberCreateEditEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<NumberCreateEditDTO> doUpdateEntity(NumberCreateEditEntity entity, NumberCreateEditDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(NumberCreateEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<NumberCreateEditDTO> getActions() {
		return Actions.<NumberCreateEditDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}