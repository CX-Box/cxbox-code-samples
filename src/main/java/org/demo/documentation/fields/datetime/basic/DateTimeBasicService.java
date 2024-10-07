package org.demo.documentation.fields.datetime.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class DateTimeBasicService extends VersionAwareResponseService<DateTimeBasicDTO, DateTimeBasic> {

	private final DateTimeBasicRepository repository;

	public DateTimeBasicService(DateTimeBasicRepository repository) {
		super(DateTimeBasicDTO.class, DateTimeBasic.class, null, DateTimeBasicMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateTimeBasicDTO> doCreateEntity(DateTimeBasic entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeBasicDTO> doUpdateEntity(DateTimeBasic entity, DateTimeBasicDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeBasicDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeBasicDTO> getActions() {
		return Actions.<DateTimeBasicDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}