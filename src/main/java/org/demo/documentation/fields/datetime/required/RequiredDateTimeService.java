package org.demo.documentation.fields.datetime.required;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class RequiredDateTimeService extends VersionAwareResponseService<RequiredDateTimeDTO, RequiredDateTime> {

	private final RequiredDateTimeRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<RequiredDateTimeMeta> meta = RequiredDateTimeMeta.class;

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
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}