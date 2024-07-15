package org.demo.documentation.fields.datetime.validationbusinessex;

import java.time.LocalDateTime;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.LESS_CURRENT_DATE;

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

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeValidationBusinessExDTO> doUpdateEntity(DateTimeValidationBusinessEx entity,
			DateTimeValidationBusinessExDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeValidationBusinessExDTO_.customField)) {
			LocalDateTime sysdate = LocalDateTime.now();
			if (data.getCustomField() != null && sysdate.compareTo(data.getCustomField()) > 0) {
				throw new BusinessException().addPopup(LESS_CURRENT_DATE);
			}
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeValidationBusinessExDTO> getActions() {
		return Actions.<DateTimeValidationBusinessExDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}