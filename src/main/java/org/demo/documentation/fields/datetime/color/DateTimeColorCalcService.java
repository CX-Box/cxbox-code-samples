package org.demo.documentation.fields.datetime.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeColorCalcService extends VersionAwareResponseService<DateTimeColorCalcDTO, DateTimeColorCalc> {

	private final DateTimeColorCalcRepository repository;

	public DateTimeColorCalcService(DateTimeColorCalcRepository repository) {
		super(DateTimeColorCalcDTO.class, DateTimeColorCalc.class, null, DateTimeColorCalcMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeColorCalcDTO> doCreateEntity(DateTimeColorCalc entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeColorCalcDTO> doUpdateEntity(DateTimeColorCalc entity, DateTimeColorCalcDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeColorCalcDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeColorCalcDTO> getActions() {
		return Actions.<DateTimeColorCalcDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}