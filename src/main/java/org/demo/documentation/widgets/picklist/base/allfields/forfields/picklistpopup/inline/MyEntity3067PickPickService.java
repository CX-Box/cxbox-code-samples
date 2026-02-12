package org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.inline;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067Pick;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3067PickPickService extends VersionAwareResponseService<MyEntity3067PickPickDTO, MyEntity3067Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3067PickPickMeta> meta = MyEntity3067PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3067PickPickDTO> doCreateEntity(MyEntity3067Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3067PickPickDTO> doUpdateEntity(MyEntity3067Pick entity, MyEntity3067PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}