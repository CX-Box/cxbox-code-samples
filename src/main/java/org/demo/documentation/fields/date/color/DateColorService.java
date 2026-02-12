package org.demo.documentation.fields.date.color;

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
public class DateColorService extends VersionAwareResponseService<DateColorDTO, dateColor> {

	private final dateColorRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<DateColorMeta> meta = DateColorMeta.class;

	@Override
	protected CreateResult<DateColorDTO> doCreateEntity(dateColor entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateColorDTO> doUpdateEntity(dateColor entity, DateColorDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(DateColorDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateColorDTO> getActions() {
		return Actions.<DateColorDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}