package org.demo.documentation.fields.dictionary.dictionarydictionary.old.basic;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.dictionary.dictionarydictionary.old.AdministeredDictionaryTypeOld.REGIONS;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample350Service extends VersionAwareResponseService<MyExample350DTO, MyEntity350> {

	private final MyEntity350Repository repository;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample350Meta> meta = MyExample350Meta.class;


	@Override
	protected CreateResult<MyExample350DTO> doCreateEntity(MyEntity350 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	// --8<-- [start:doUpdateEntity]
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
	// --8<-- [end:doUpdateEntity]

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample350DTO> getActions() {
		return Actions.<MyExample350DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}