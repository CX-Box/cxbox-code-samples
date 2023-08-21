package org.demo.documentation.hidden.basic;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class HiddenBasicService extends VersionAwareResponseService<HiddenBasicDTO, HiddenBasic> {

	private final HiddenBasicRepository repository;

	public HiddenBasicService(HiddenBasicRepository repository) {
		super(HiddenBasicDTO.class, HiddenBasic.class, null, HiddenBasicMeta.class);
		this.repository = repository;
	}

	@Override
	protected CreateResult<HiddenBasicDTO> doCreateEntity(HiddenBasic entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<HiddenBasicDTO> doUpdateEntity(HiddenBasic entity, HiddenBasicDTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(HiddenBasicDTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<HiddenBasicDTO> getActions() {
		return Actions.<HiddenBasicDTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}


}