package org.demo.documentation.dateytimewithseconds.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeWithSecondsRequredService extends
		VersionAwareResponseService<DateTimeWithSecondsRequredDTO, DateTimeWithSecondsRequredEntity> {

	private final DateTimeWithSecondsRequredEntityRepository repository;

	public DateTimeWithSecondsRequredService(DateTimeWithSecondsRequredEntityRepository repository) {
		super(
				DateTimeWithSecondsRequredDTO.class,
				DateTimeWithSecondsRequredEntity.class,
				null,
				DateTimeWithSecondsRequredMeta.class
		);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeWithSecondsRequredDTO> doCreateEntity(DateTimeWithSecondsRequredEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeWithSecondsRequredDTO> doUpdateEntity(DateTimeWithSecondsRequredEntity entity,
			DateTimeWithSecondsRequredDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeWithSecondsRequredDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeWithSecondsRequredDTO> getActions() {
		return Actions.<DateTimeWithSecondsRequredDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}