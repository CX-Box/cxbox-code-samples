package org.demo.documentation.date.validationbusinessex;

import java.time.LocalDateTime;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateValidationBusinessExService extends
		VersionAwareResponseService<DateValidationBusinessExDTO, DateValidationBusinessExEntity> {

	private final DateValidationBusinessExEntityRepository repository;

	public DateValidationBusinessExService(DateValidationBusinessExEntityRepository repository) {
		super(
				DateValidationBusinessExDTO.class,
				DateValidationBusinessExEntity.class,
				null,
				DateValidationBusinessExMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateValidationBusinessExDTO> doCreateEntity(DateValidationBusinessExEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateValidationBusinessExDTO> doUpdateEntity(DateValidationBusinessExEntity entity,
			DateValidationBusinessExDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateValidationBusinessExDTO_.customField)) {
			LocalDateTime sysdate = LocalDateTime.now();
			if (data.getCustomField() != null && sysdate.compareTo(data.getCustomField()) > 0) {
				throw new BusinessException().addPopup("The field 'customField' cannot be less than the current date");
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateValidationBusinessExDTO> getActions() {
		return Actions.<DateValidationBusinessExDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}