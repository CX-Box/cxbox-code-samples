package org.demo.documentation.fields.date.filtration;

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
public class DateFiltrationService extends VersionAwareResponseService<DateFiltrationDTO, dateFiltrationEntity> {

	private final dateFiltrationEntityRepository repository;
    @Getter(onMethod_ = @Override)
    private final Class<DateFiltrationMeta> meta = DateFiltrationMeta.class;

    @Override
	protected CreateResult<DateFiltrationDTO> doCreateEntity(dateFiltrationEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
	@Override
	protected ActionResultDTO<DateFiltrationDTO> doUpdateEntity(dateFiltrationEntity entity, DateFiltrationDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(DateFiltrationDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<DateFiltrationDTO> getActions() {
		return Actions.<DateFiltrationDTO>builder()
               .save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]


}