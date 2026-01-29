package org.demo.documentation.fields.date.validationconfirm;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PreAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class DateConfirmService extends VersionAwareResponseService<DateConfirmDTO, DateConfirmEntity> {

	private final DateConfirmEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateConfirmMeta> meta = DateConfirmMeta.class;

    @Override
	protected CreateResult<DateConfirmDTO> doCreateEntity(DateConfirmEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateConfirmDTO> doUpdateEntity(DateConfirmEntity entity, DateConfirmDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateConfirmDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateConfirmDTO> getActions() {
		return Actions.<DateConfirmDTO>builder()
				.action(act -> act
						.action("save", "save")
						.withPreAction(PreAction.confirm(cf -> cf
								.text("You want to save the value?")
						)))
				.build();
	}
	// --8<-- [end:getActions]


}