package org.demo.documentation.widgets.property.excel.inner.forfields;

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
public class MyEntity3134PickPickService extends VersionAwareResponseService<MyEntity3134PickPickDTO, MyEntity3134Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3134PickPickMeta> meta = MyEntity3134PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3134PickPickDTO> doCreateEntity(MyEntity3134Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3134PickPickDTO> doUpdateEntity(MyEntity3134Pick entity, MyEntity3134PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}