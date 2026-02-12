package org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc;

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
public class MyEntity3624PickService extends VersionAwareResponseService<MyEntity3624PickDTO, org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3624PickMeta> meta = MyEntity3624PickMeta.class;

	@Override
	protected CreateResult<MyEntity3624PickDTO> doCreateEntity(org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3624PickDTO> doUpdateEntity(org.demo.documentation.widgets.property.filtration.filtergroupsave.forassoc.MyEntity3624 entity, MyEntity3624PickDTO data,
																  BusinessComponent bc) {
		setIfChanged(data, MyEntity3624PickDTO_.customFieldDictionary, entity::setCustomFieldDictionary);
		return null;
	}


}