package org.demo.documentation.fields.datetime.colorconst;

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
public class DateTimeColorService extends VersionAwareResponseService<DateTimeColorDTO, DateTimeColor> {

	private final DateTimeColorRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateTimeColorMeta> meta = DateTimeColorMeta.class;

	@Override
	protected CreateResult<DateTimeColorDTO> doCreateEntity(DateTimeColor entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateTimeColorDTO> doUpdateEntity(DateTimeColor entity, DateTimeColorDTO data,
															   BusinessComponent bc) {
		if (data.isFieldChanged(DateTimeColorDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateTimeColorDTO> getActions() {
		return Actions.<DateTimeColorDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}