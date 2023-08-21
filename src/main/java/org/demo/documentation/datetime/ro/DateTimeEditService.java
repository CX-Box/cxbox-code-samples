package org.demo.documentation.datetime.ro;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class DateTimeEditService extends VersionAwareResponseService<DateTimeEditDTO, DateTimeEdit> {

	private final DateTimeEditRepository repository;

	public DateTimeEditService(DateTimeEditRepository repository) {
		super(DateTimeEditDTO.class, DateTimeEdit.class, null, DateTimeEditMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeEditDTO> doCreateEntity(DateTimeEdit entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeEditDTO> doUpdateEntity(DateTimeEdit entity, DateTimeEditDTO data,
			BusinessComponent bc) {

		if (data.isFieldChanged(DateTimeEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeEditDTO> getActions() {
		return Actions.<DateTimeEditDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}