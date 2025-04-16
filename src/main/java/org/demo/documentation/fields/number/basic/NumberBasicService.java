package org.demo.documentation.fields.number.basic;

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
public class NumberBasicService extends VersionAwareResponseService<NumberBasicDTO, NumberBasicEntity> {

	private final NumberBasicEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<NumberBasicMeta> meta = NumberBasicMeta.class;

    @Override
	protected CreateResult<NumberBasicDTO> doCreateEntity(NumberBasicEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberBasicDTO> doUpdateEntity(NumberBasicEntity entity, NumberBasicDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(NumberBasicDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberBasicDTO> getActions() {
		return Actions.<NumberBasicDTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
				.build();
	}
	// --8<-- [end:getActions]


}