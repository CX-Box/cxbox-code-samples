package org.demo.documentation.widgets.picklist.title.withtitle;

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
public class MyEntity3068PickPickService extends VersionAwareResponseService<MyEntity3068PickPickDTO, MyEntity3068Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3068PickPickMeta> meta = MyEntity3068PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3068PickPickDTO> doCreateEntity(MyEntity3068Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3068PickPickDTO> doUpdateEntity(MyEntity3068Pick entity, MyEntity3068PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}