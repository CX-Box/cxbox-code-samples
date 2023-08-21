package org.demo.documentation.number.required;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class NumberRequiredService extends VersionAwareResponseService<NumberRequiredDTO, NumberRequiredEntity> {

	private final NumberRequiredEntityRepository repository;

	public NumberRequiredService(NumberRequiredEntityRepository repository) {
		super(NumberRequiredDTO.class, NumberRequiredEntity.class, null, NumberRequiredMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<NumberRequiredDTO> doCreateEntity(NumberRequiredEntity entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<NumberRequiredDTO> doUpdateEntity(NumberRequiredEntity entity, NumberRequiredDTO data,
			BusinessComponent bc) {

		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<NumberRequiredDTO> getActions() {
		return Actions.<NumberRequiredDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}