package org.demo.documentation.date.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateRequiredService extends VersionAwareResponseService<DateRequiredDTO, DateRequiredEntity> {

	private final DateRequiredEntityRepository repository;

	public DateRequiredService(DateRequiredEntityRepository repository) {
		super(DateRequiredDTO.class, DateRequiredEntity.class, null, DateRequiredMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateRequiredDTO> doCreateEntity(DateRequiredEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateRequiredDTO> doUpdateEntity(DateRequiredEntity entity, DateRequiredDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateRequiredDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateRequiredDTO> getActions() {
		return Actions.<DateRequiredDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}