package org.demo.documentation.fields.dictionary.icon.picklistpopup;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3012PickService extends VersionAwareResponseService<MyEntity3012PickDTO, MyEntity3012> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3012PickMeta> meta = MyEntity3012PickMeta.class;

	@Override
	protected CreateResult<MyEntity3012PickDTO> doCreateEntity(MyEntity3012 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3012PickDTO> doUpdateEntity(MyEntity3012 entity, MyEntity3012PickDTO data,
																  BusinessComponent bc) {
		setIfChanged(data, MyEntity3012PickDTO_.customField, entity::setCustomField);
		setIfChanged(data, MyEntity3012PickDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}