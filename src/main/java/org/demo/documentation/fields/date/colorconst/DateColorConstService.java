package org.demo.documentation.fields.date.colorconst;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class DateColorConstService extends VersionAwareResponseService<DateColorConstDTO, dateColorConstEntity> {

	private final dateColorConstEntityRepository repository;

	public DateColorConstService(dateColorConstEntityRepository repository) {
		super(DateColorConstDTO.class, dateColorConstEntity.class, null, DateColorConstMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateColorConstDTO> doCreateEntity(dateColorConstEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateColorConstDTO> doUpdateEntity(dateColorConstEntity entity, DateColorConstDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateColorConstDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateColorConstDTO> getActions() {
		return Actions.<DateColorConstDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}