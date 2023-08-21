package org.demo.documentation.input.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputBasicService extends VersionAwareResponseService<InputBasicDTO, InputBasic> {

	private final InputBasicRepository repository;

	public InputBasicService(InputBasicRepository repository) {
		super(InputBasicDTO.class, InputBasic.class, null, InputBasicMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputBasicDTO> doCreateEntity(InputBasic entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<InputBasicDTO> doUpdateEntity(InputBasic entity, InputBasicDTO data, BusinessComponent bc) {
		if (data.isFieldChanged(InputBasicDTO_.customFieldRO)) {
			entity.setCustomFieldRO(data.getCustomFieldRO());
		}
		if (data.isFieldChanged(InputBasicDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<InputBasicDTO> getActions() {
		return Actions.<InputBasicDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}
