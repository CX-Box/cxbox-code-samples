package org.demo.documentation.widgets.picklist.fieldslayoute;

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
public class MyEntity3070PickPickService extends VersionAwareResponseService<MyEntity3070PickPickDTO, MyEntity3070Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3070PickPickMeta> meta = MyEntity3070PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3070PickPickDTO> doCreateEntity(MyEntity3070Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3070PickPickDTO> doUpdateEntity(MyEntity3070Pick entity, MyEntity3070PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}