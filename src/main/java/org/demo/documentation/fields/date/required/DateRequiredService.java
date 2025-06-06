package org.demo.documentation.fields.date.required;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
@RequiredArgsConstructor
public class DateRequiredService extends VersionAwareResponseService<DateRequiredDTO, DateRequiredEntity> {

	private final DateRequiredEntityRepository repository;

	@Getter(onMethod_ = @Override)
	private final Class<? extends FieldMetaBuilder<DateRequiredDTO>> meta = DateRequiredMeta.class;


	@Override
	protected CreateResult<DateRequiredDTO> doCreateEntity(DateRequiredEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateRequiredDTO> doUpdateEntity(DateRequiredEntity entity, DateRequiredDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateRequiredDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateRequiredDTO> getActions() {
		return Actions.<DateRequiredDTO>builder()
				.action(act -> act
						.action("save", "save")
				)
				.build();
	}
	// --8<-- [end:getActions]


}