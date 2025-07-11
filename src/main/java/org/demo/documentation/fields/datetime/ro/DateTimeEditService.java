package org.demo.documentation.fields.datetime.ro;

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
public class DateTimeEditService extends VersionAwareResponseService<DateTimeEditDTO, DateTimeEdit> {

	private final DateTimeEditRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeEditMeta> meta = DateTimeEditMeta.class;

    @Override
	protected CreateResult<DateTimeEditDTO> doCreateEntity(DateTimeEdit entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeEditDTO> doUpdateEntity(DateTimeEdit entity, DateTimeEditDTO data,
			BusinessComponent bc) {

		if (data.isFieldChanged(DateTimeEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeEditDTO> getActions() {
		return Actions.<DateTimeEditDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}