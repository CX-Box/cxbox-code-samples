package org.demo.documentation.widgets.picktree.colortitle.forfields;

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
public class MyEntity3342PickPickService extends VersionAwareResponseService<MyEntity3342PickPickDTO, MyEntity3342Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3342PickPickMeta> meta = MyEntity3342PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3342PickPickDTO> doCreateEntity(MyEntity3342Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3342PickPickDTO> doUpdateEntity(MyEntity3342Pick entity, MyEntity3342PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}