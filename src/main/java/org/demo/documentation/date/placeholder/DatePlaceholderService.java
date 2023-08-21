package org.demo.documentation.date.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class DatePlaceholderService extends VersionAwareResponseService<DatePlaceholderDTO, DatePlaceholderEntity> {

	private final DatePlaceholderEntityRepository repository;

	public DatePlaceholderService(DatePlaceholderEntityRepository repository) {
		super(DatePlaceholderDTO.class, DatePlaceholderEntity.class, null, DatePlaceholderMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DatePlaceholderDTO> doCreateEntity(DatePlaceholderEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<DatePlaceholderDTO> doUpdateEntity(DatePlaceholderEntity entity, DatePlaceholderDTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<DatePlaceholderDTO> getActions() {
		return Actions.<DatePlaceholderDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}