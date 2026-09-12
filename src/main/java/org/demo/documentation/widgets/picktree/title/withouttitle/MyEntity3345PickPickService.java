package org.demo.documentation.widgets.picktree.title.withouttitle;

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
public class MyEntity3345PickPickService extends VersionAwareResponseService<MyEntity3345PickPickDTO, MyEntity3345Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3345PickPickMeta> meta = MyEntity3345PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3345PickPickDTO> doCreateEntity(MyEntity3345Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3345PickPickDTO> doUpdateEntity(MyEntity3345Pick entity, MyEntity3345PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}