package org.demo.documentation.datetimewithseconds.validationconfirm;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeWithSecondsValidationBusinessExService extends
		VersionAwareResponseService<DateTimeWithSecondsValidationBusinessExDTO, DateTimeWithSecondsValidationBusinessExEntity> {

	private final DateTimeWithSecondsValidationBusinessExEntityRepository repository;

	public DateTimeWithSecondsValidationBusinessExService(
			DateTimeWithSecondsValidationBusinessExEntityRepository repository) {
		super(
				DateTimeWithSecondsValidationBusinessExDTO.class,
				DateTimeWithSecondsValidationBusinessExEntity.class,
				null,
				DateTimeWithSecondsValidationBusinessExMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsValidationBusinessExDTO> doCreateEntity(
			DateTimeWithSecondsValidationBusinessExEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeWithSecondsValidationBusinessExDTO> doUpdateEntity(
			DateTimeWithSecondsValidationBusinessExEntity entity, DateTimeWithSecondsValidationBusinessExDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsValidationBusinessExDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeWithSecondsValidationBusinessExDTO> getActions() {
		return Actions.<DateTimeWithSecondsValidationBusinessExDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}