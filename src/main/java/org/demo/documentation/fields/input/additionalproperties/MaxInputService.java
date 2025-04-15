package org.demo.documentation.fields.input.additionalproperties;

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
public class MaxInputService extends VersionAwareResponseService<MaxInputDTO, MaxInputEntity> {

	private final MaxInputEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MaxInputMeta> meta = MaxInputMeta.class;

    @Override
	protected CreateResult<MaxInputDTO> doCreateEntity(MaxInputEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<MaxInputDTO> doUpdateEntity(MaxInputEntity entity, MaxInputDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(MaxInputDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MaxInputDTO> getActions() {
		return Actions.<MaxInputDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}