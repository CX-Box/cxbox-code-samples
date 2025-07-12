package org.demo.documentation.fields.number.drilldown;

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
public class NumberDrillDownService extends VersionAwareResponseService<NumberDrillDownDTO, NumberDrillDownEntity> {

	private final NumberDrillDownEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<NumberDrillDownMeta> meta = NumberDrillDownMeta.class;

    @Override
	protected CreateResult<NumberDrillDownDTO> doCreateEntity(NumberDrillDownEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberDrillDownDTO> doUpdateEntity(NumberDrillDownEntity entity, NumberDrillDownDTO data,
			BusinessComponent bc) {
		setIfChanged(data, NumberDrillDownDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberDrillDownDTO> getActions() {
		return Actions.<NumberDrillDownDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}