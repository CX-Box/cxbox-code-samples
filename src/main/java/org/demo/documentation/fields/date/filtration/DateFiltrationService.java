package org.demo.documentation.fields.date.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.date.filtration.DateFiltrationDTO_;
import org.springframework.stereotype.Service;

@Service
public class DateFiltrationService extends VersionAwareResponseService<DateFiltrationDTO, dateFiltrationEntity> {

	private final dateFiltrationEntityRepository repository;

	public DateFiltrationService(dateFiltrationEntityRepository repository) {
		super(DateFiltrationDTO.class, dateFiltrationEntity.class, null, DateFiltrationMeta.class);
		this.repository = repository;
	}

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
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}
	// --8<-- [end:getActions]


}