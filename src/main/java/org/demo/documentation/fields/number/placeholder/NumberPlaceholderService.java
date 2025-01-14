package org.demo.documentation.fields.number.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class NumberPlaceholderService extends
		VersionAwareResponseService<NumberPlaceholderDTO, NumberPlaceholderEntity> {

	private final NumberPlaceholderEntityRepository repository;

	public NumberPlaceholderService(NumberPlaceholderEntityRepository repository) {
		super(NumberPlaceholderDTO.class, NumberPlaceholderEntity.class, null, NumberPlaceholderMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberPlaceholderDTO> doCreateEntity(NumberPlaceholderEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberPlaceholderDTO> doUpdateEntity(NumberPlaceholderEntity entity,
			NumberPlaceholderDTO data, BusinessComponent bc) {
		setIfChanged(data, NumberPlaceholderDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberPlaceholderDTO> getActions() {
		return Actions.<NumberPlaceholderDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}