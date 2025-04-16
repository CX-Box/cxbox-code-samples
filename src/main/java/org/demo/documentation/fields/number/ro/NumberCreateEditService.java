package org.demo.documentation.fields.number.ro;

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
public class NumberCreateEditService extends VersionAwareResponseService<NumberCreateEditDTO, NumberCreateEditEntity> {

	private final NumberCreateEditEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<NumberCreateEditMeta> meta = NumberCreateEditMeta.class;

    @Override
	protected CreateResult<NumberCreateEditDTO> doCreateEntity(NumberCreateEditEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberCreateEditDTO> doUpdateEntity(NumberCreateEditEntity entity, NumberCreateEditDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(NumberCreateEditDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberCreateEditDTO> getActions() {
		return Actions.<NumberCreateEditDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}