package org.demo.documentation.fields.picktree.required;

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
public class MyEntity3288PickPickTreeService extends VersionAwareResponseService<MyEntity3288PickDTO, MyEntity3288Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3288PickPickTreeMeta> meta = MyEntity3288PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3288PickDTO> doCreateEntity(MyEntity3288Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3288PickDTO> doUpdateEntity(MyEntity3288Pick entity, MyEntity3288PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}