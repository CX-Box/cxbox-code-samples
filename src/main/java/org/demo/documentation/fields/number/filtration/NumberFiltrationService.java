package org.demo.documentation.fields.number.filtration;

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
public class NumberFiltrationService extends VersionAwareResponseService<NumberFiltrationDTO, NumberFiltrationEntity> {

	private final NumberFiltrationEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<NumberFiltrationMeta> meta = NumberFiltrationMeta.class;

    @Override
	protected CreateResult<NumberFiltrationDTO> doCreateEntity(NumberFiltrationEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<NumberFiltrationDTO> doUpdateEntity(NumberFiltrationEntity entity, NumberFiltrationDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(NumberFiltrationDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<NumberFiltrationDTO> getActions() {
		return Actions.<NumberFiltrationDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}