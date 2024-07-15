package org.demo.documentation.fields.datetime.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class DateTimeFiltrationService extends VersionAwareResponseService<DateTimeFiltrationDTO, DateTimeFiltration> {

	private final DateTimeFiltrationRepository repository;

	public DateTimeFiltrationService(DateTimeFiltrationRepository repository) {
		super(DateTimeFiltrationDTO.class, DateTimeFiltration.class, null, DateTimeFiltrationMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeFiltrationDTO> doCreateEntity(DateTimeFiltration entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeFiltrationDTO> doUpdateEntity(DateTimeFiltration entity, DateTimeFiltrationDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeFiltrationDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeFiltrationDTO> getActions() {
		return Actions.<DateTimeFiltrationDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}