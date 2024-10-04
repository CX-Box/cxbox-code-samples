package org.demo.documentation.fields.date.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class DateBasicService extends VersionAwareResponseService<DateBasicDTO, DateBasic> {

	private final DateBasicRepository repository;

	public DateBasicService(DateBasicRepository repository) {
		super(DateBasicDTO.class, DateBasic.class, null, DateBasicMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<DateBasicDTO> doCreateEntity(DateBasic entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateBasicDTO> doUpdateEntity(DateBasic entity, DateBasicDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateBasicDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateBasicDTO> getActions() {
		return Actions.<DateBasicDTO>builder()
				.action(act -> act
						.action("save", "save")
				)
				.build();
	}
	// --8<-- [end:getActions]


}