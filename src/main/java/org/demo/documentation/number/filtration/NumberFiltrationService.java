package org.demo.documentation.number.filtration;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class NumberFiltrationService extends VersionAwareResponseService<NumberFiltrationDTO, NumberFiltrationEntity> {

	private final NumberFiltrationEntityRepository repository;

	public NumberFiltrationService(NumberFiltrationEntityRepository repository) {
		super(NumberFiltrationDTO.class, NumberFiltrationEntity.class, null, NumberFiltrationMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberFiltrationDTO> doCreateEntity(NumberFiltrationEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<NumberFiltrationDTO> doUpdateEntity(NumberFiltrationEntity entity, NumberFiltrationDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(NumberFiltrationDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<NumberFiltrationDTO> getActions() {
		return Actions.<NumberFiltrationDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}