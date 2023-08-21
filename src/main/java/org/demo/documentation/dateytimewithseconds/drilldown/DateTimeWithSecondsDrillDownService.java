package org.demo.documentation.dateytimewithseconds.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeWithSecondsDrillDownService extends
		VersionAwareResponseService<DateTimeWithSecondsDrillDownDTO, DateTimeWithSecondsDrillDownEntity> {

	private final DateTimeWithSecondsDrillDownEntityRepository repository;

	public DateTimeWithSecondsDrillDownService(DateTimeWithSecondsDrillDownEntityRepository repository) {
		super(
				DateTimeWithSecondsDrillDownDTO.class,
				DateTimeWithSecondsDrillDownEntity.class,
				null,
				DateTimeWithSecondsDrillDownMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsDrillDownDTO> doCreateEntity(DateTimeWithSecondsDrillDownEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeWithSecondsDrillDownDTO> doUpdateEntity(DateTimeWithSecondsDrillDownEntity entity,
			DateTimeWithSecondsDrillDownDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsDrillDownDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeWithSecondsDrillDownDTO> getActions() {
		return Actions.<DateTimeWithSecondsDrillDownDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}