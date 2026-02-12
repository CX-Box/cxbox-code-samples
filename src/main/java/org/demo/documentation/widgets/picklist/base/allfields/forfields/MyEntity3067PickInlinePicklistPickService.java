package org.demo.documentation.widgets.picklist.base.allfields.forfields;

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
public class MyEntity3067PickInlinePicklistPickService extends VersionAwareResponseService<MyEntity3067PickInlinePicklistPickDTO, MyEntity3067PickInlinePicklist> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3067PickInlinePicklistPickMeta> meta = MyEntity3067PickInlinePicklistPickMeta.class;

	@Override
	protected CreateResult<MyEntity3067PickInlinePicklistPickDTO> doCreateEntity(MyEntity3067PickInlinePicklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3067PickInlinePicklistPickDTO> doUpdateEntity(MyEntity3067PickInlinePicklist entity, MyEntity3067PickInlinePicklistPickDTO data,
																					BusinessComponent bc) {
		return null;
	}


}