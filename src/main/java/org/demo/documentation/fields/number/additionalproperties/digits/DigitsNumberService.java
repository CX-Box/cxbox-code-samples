package org.demo.documentation.fields.number.additionalproperties.digits;

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
public class DigitsNumberService extends VersionAwareResponseService<DigitsNumberDTO, DigitsNumberEntity> {

	private final DigitsNumberEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DigitsNumberMeta> meta = DigitsNumberMeta.class;

    @Override
	protected CreateResult<DigitsNumberDTO> doCreateEntity(DigitsNumberEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DigitsNumberDTO> doUpdateEntity(DigitsNumberEntity entity, DigitsNumberDTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DigitsNumberDTO> getActions() {
		return Actions.<DigitsNumberDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}