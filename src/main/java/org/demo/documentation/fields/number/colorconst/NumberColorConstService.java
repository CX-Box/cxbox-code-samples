package org.demo.documentation.fields.number.colorconst;

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
public class NumberColorConstService extends VersionAwareResponseService<NumberColorConstDTO, NumberColorConstEntity> {

	private final NumberColorConstEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<NumberColorConstMeta> meta = NumberColorConstMeta.class;

    @Override
	protected CreateResult<NumberColorConstDTO> doCreateEntity(NumberColorConstEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberColorConstDTO> doUpdateEntity(NumberColorConstEntity entity, NumberColorConstDTO data,
			BusinessComponent bc) {
		setIfChanged(data, NumberColorConstDTO_.customField, entity::setCustomField);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberColorConstDTO> getActions() {
		return Actions.<NumberColorConstDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}