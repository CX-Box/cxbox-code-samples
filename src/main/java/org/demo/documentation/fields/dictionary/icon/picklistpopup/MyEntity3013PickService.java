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
public class MyEntity3013PickService extends VersionAwareResponseService<MyEntity3013PickDTO, MyEntity3013> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3013PickMeta> meta = MyEntity3013PickMeta.class;

	@Override
	protected CreateResult<MyEntity3013PickDTO> doCreateEntity(MyEntity3013 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3013PickDTO> doUpdateEntity(MyEntity3013 entity, MyEntity3013PickDTO data,
																  BusinessComponent bc) {
		setIfChanged(data, MyEntity3013PickDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

}