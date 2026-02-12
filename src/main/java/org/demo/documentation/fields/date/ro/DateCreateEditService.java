package org.demo.documentation.fields.date.ro;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class DateCreateEditService extends VersionAwareResponseService<DateCreateEditDTO, DateCreateEditEntity> {

	private final DateCreateEditEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateCreateEditMeta> meta = DateCreateEditMeta.class;

	@Override
	protected CreateResult<DateCreateEditDTO> doCreateEntity(DateCreateEditEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateCreateEditDTO> doUpdateEntity(DateCreateEditEntity entity, DateCreateEditDTO data,
																BusinessComponent bc) {
		if (data.isFieldChanged(DateCreateEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateCreateEditDTO> getActions() {
		return Actions.<DateCreateEditDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}