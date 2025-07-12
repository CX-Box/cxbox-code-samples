package org.demo.documentation.fields.datetime.filtration;

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
public class DateTimeFiltrationService extends VersionAwareResponseService<DateTimeFiltrationDTO, DateTimeFiltration> {

	private final DateTimeFiltrationRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateTimeFiltrationMeta> meta = DateTimeFiltrationMeta.class;

    @Override
	protected CreateResult<DateTimeFiltrationDTO> doCreateEntity(DateTimeFiltration entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeFiltrationDTO> doUpdateEntity(DateTimeFiltration entity, DateTimeFiltrationDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeFiltrationDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeFiltrationDTO> getActions() {
		return Actions.<DateTimeFiltrationDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}