package org.demo.documentation.fields.number.color;

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
public class NumberColorService extends VersionAwareResponseService<NumberColorDTO, NumberColorEntity> {

	private final NumberColorEntityRepository repository;
	@Getter(onMethod_ = @Override)
	private final Class<NumberColorMeta> meta = NumberColorMeta.class;

	@Override
	protected CreateResult<NumberColorDTO> doCreateEntity(NumberColorEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberColorDTO> doUpdateEntity(NumberColorEntity entity, NumberColorDTO data,
															 BusinessComponent bc) {
		setIfChanged(data, NumberColorDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberColorDTO> getActions() {
		return Actions.<NumberColorDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}