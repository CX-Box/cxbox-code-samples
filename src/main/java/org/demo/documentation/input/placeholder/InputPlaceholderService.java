package org.demo.documentation.input.placeholder;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class InputPlaceholderService extends VersionAwareResponseService<InputPlaceholderDTO, InputPlaceholder> {

	private final InputPlaceholderRepository repository;

	public InputPlaceholderService(InputPlaceholderRepository repository) {
		super(InputPlaceholderDTO.class, InputPlaceholder.class, null, InputPlaceholderMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<InputPlaceholderDTO> doCreateEntity(InputPlaceholder entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<InputPlaceholderDTO> doUpdateEntity(InputPlaceholder entity, InputPlaceholderDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(InputPlaceholderDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<InputPlaceholderDTO> getActions() {
		return Actions.<InputPlaceholderDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}
