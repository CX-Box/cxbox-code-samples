package org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields;

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
public class MyEntity3192PickPickService extends VersionAwareResponseService<MyEntity3192PickPickDTO, MyEntity3192Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3192PickPickMeta> meta = MyEntity3192PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3192PickPickDTO> doCreateEntity(MyEntity3192Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3192PickPickDTO> doUpdateEntity(MyEntity3192Pick entity, MyEntity3192PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}