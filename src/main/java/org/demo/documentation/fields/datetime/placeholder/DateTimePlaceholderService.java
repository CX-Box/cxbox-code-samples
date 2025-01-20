package org.demo.documentation.fields.datetime.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class DateTimePlaceholderService extends
		VersionAwareResponseService<DateTimePlaceholderDTO, DateTimePlaceholderEntity> {

	private final DateTimePlaceholderEntityRepository repository;

	public DateTimePlaceholderService(DateTimePlaceholderEntityRepository repository) {
		super(DateTimePlaceholderDTO.class, DateTimePlaceholderEntity.class, null, DateTimePlaceholderMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimePlaceholderDTO> doCreateEntity(DateTimePlaceholderEntity entity,
			BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimePlaceholderDTO> doUpdateEntity(DateTimePlaceholderEntity entity,
			DateTimePlaceholderDTO data, BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimePlaceholderDTO> getActions() {
		return Actions.<DateTimePlaceholderDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}