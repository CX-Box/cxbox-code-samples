package org.demo.documentation.dictionary.dictionarylov;

import static org.demo.documentation.dictionary.dictionarylov.AdministeredDictionaryType.REGIONS;

import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.services.CustomDynamicErrorService;
import org.springframework.stereotype.Service;

@Service
public class MyExample350Service extends VersionAwareResponseService<MyExample350DTO, MyEntity350> {

	private final MyEntity350Repository repository;

	private final CustomDynamicErrorService dynamicError;

	public MyExample350Service(MyEntity350Repository repository, CustomDynamicErrorService dynamicError) {
		super(MyExample350DTO.class, MyEntity350.class, null, MyExample350Meta.class);
		this.repository = repository;
		this.dynamicError = dynamicError;
	}

	@Override
	protected CreateResult<MyExample350DTO> doCreateEntity(MyEntity350 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample350DTO> doUpdateEntity(MyEntity350 entity, MyExample350DTO data,
			BusinessComponent bc) {
		setMappedIfChanged(data, MyExample350DTO_.customField, entity::setCustomField, val -> {
			if (StringUtils.isNotBlank(val)) {
				return REGIONS.lookupName(val);
			} else {
				return null;
			}
		});
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample350DTO> getActions() {
		return Actions.<MyExample350DTO>builder()
				.newAction()
				.action("save", "save")
				.add()
				.build();
	}

}