package org.demo.documentation.widgets.additionalinfo.base.forfields;

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
public class MyEntity3600Pick2PickService extends VersionAwareResponseService<MyEntity3600Pick2PickDTO, MyEntity3600Pick2> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3600Pick2PickMeta> meta = MyEntity3600Pick2PickMeta.class;

	@Override
	protected CreateResult<MyEntity3600Pick2PickDTO> doCreateEntity(MyEntity3600Pick2 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3600Pick2PickDTO> doUpdateEntity(MyEntity3600Pick2 entity, MyEntity3600Pick2PickDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}