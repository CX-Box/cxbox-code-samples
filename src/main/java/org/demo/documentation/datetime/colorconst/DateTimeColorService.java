package org.demo.documentation.datetime.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DateTimeColorService extends VersionAwareResponseService<DateTimeColorDTO, DateTimeColor> {

	private final DateTimeColorRepository repository;

	public DateTimeColorService(DateTimeColorRepository repository) {
		super(DateTimeColorDTO.class, DateTimeColor.class, null, DateTimeColorMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeColorDTO> doCreateEntity(DateTimeColor entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DateTimeColorDTO> doUpdateEntity(DateTimeColor entity, DateTimeColorDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeColorDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DateTimeColorDTO> getActions() {
		return Actions.<DateTimeColorDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}