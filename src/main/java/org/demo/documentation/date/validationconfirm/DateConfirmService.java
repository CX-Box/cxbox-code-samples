package org.demo.documentation.date.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateConfirmService extends VersionAwareResponseService<DateConfirmDTO, DateConfirmEntity> {

	private final DateConfirmEntityRepository repository;

	public DateConfirmService(DateConfirmEntityRepository repository) {
		super(DateConfirmDTO.class, DateConfirmEntity.class, null, DateConfirmMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateConfirmDTO> doCreateEntity(DateConfirmEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateConfirmDTO> doUpdateEntity(DateConfirmEntity entity, DateConfirmDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateConfirmDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateConfirmDTO> getActions() {
		return Actions.<DateConfirmDTO>builder()
				.newAction()
				.action("save", "save")
				.withPreAction(PreAction.confirm("You want to save the value 'customField'?"))
				.add()
				.build();
	}


}