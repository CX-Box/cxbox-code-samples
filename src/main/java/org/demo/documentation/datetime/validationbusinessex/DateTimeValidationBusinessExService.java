package org.demo.documentation.datetime.validationbusinessex;

import java.time.LocalDate;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeValidationBusinessExService extends
		VersionAwareResponseService<DateTimeValidationBusinessExDTO, DateTimeValidationBusinessEx> {

	private final DateTimeValidationBusinessExRepository repository;

	public DateTimeValidationBusinessExService(DateTimeValidationBusinessExRepository repository) {
		super(
				DateTimeValidationBusinessExDTO.class,
				DateTimeValidationBusinessEx.class,
				null,
				DateTimeValidationBusinessExMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeValidationBusinessExDTO> doCreateEntity(DateTimeValidationBusinessEx entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeValidationBusinessExDTO> doUpdateEntity(DateTimeValidationBusinessEx entity,
			DateTimeValidationBusinessExDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeValidationBusinessExDTO_.customField)) {
			LocalDate sysdate = LocalDate.now();
			if (sysdate.compareTo(data.getCustomField().toLocalDate()) > 0) {
				throw new BusinessException().addPopup("The field 'customField' cannot be less than the current date");
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeValidationBusinessExDTO> getActions() {
		return Actions.<DateTimeValidationBusinessExDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}