package org.demo.documentation.fields.number.required;

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
public class NumberRequiredService extends VersionAwareResponseService<NumberRequiredDTO, NumberRequiredEntity> {

	private final NumberRequiredEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<NumberRequiredMeta> meta = NumberRequiredMeta.class;

    @Override
	protected CreateResult<NumberRequiredDTO> doCreateEntity(NumberRequiredEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberRequiredDTO> doUpdateEntity(NumberRequiredEntity entity, NumberRequiredDTO data,
			BusinessComponent bc) {
		setIfChanged(data, NumberRequiredDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberRequiredDTO> getActions() {
		return Actions.<NumberRequiredDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}