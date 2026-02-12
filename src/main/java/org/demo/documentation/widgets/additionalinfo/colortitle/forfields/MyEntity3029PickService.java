package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

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
public class MyEntity3029PickService extends VersionAwareResponseService<MyEntity3029PickDTO, MyEntity3029> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3029PickMeta> meta = MyEntity3029PickMeta.class;

	@Override
	protected CreateResult<MyEntity3029PickDTO> doCreateEntity(MyEntity3029 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3029PickDTO> doUpdateEntity(MyEntity3029 entity, MyEntity3029PickDTO data,
																  BusinessComponent bc) {
		return null;
	}


}