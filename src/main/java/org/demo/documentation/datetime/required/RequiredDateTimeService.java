package org.demo.documentation.datetime.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class RequiredDateTimeService extends VersionAwareResponseService<RequiredDateTimeDTO, RequiredDateTime> {

	private final RequiredDateTimeRepository repository;

	public RequiredDateTimeService(RequiredDateTimeRepository repository) {
		super(RequiredDateTimeDTO.class, RequiredDateTime.class, null, RequiredDateTimeMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<RequiredDateTimeDTO> doCreateEntity(RequiredDateTime entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<RequiredDateTimeDTO> doUpdateEntity(RequiredDateTime entity, RequiredDateTimeDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(RequiredDateTimeDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<RequiredDateTimeDTO> getActions() {
		return Actions.<RequiredDateTimeDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}