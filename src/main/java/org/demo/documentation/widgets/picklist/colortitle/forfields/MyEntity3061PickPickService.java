package org.demo.documentation.widgets.picklist.colortitle.forfields;

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
public class MyEntity3061PickPickService extends VersionAwareResponseService<MyEntity3061PickPickDTO, MyEntity3061Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3061PickPickMeta> meta = MyEntity3061PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3061PickPickDTO> doCreateEntity(MyEntity3061Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3061PickPickDTO> doUpdateEntity(MyEntity3061Pick entity, MyEntity3061PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}