package org.demo.documentation.fields.picktree.color;

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
public class MyEntity3283PickPickTreeService extends VersionAwareResponseService<MyEntity3283PickDTO, MyEntity3283Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3283PickPickTreeMeta> meta = MyEntity3283PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3283PickDTO> doCreateEntity(MyEntity3283Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3283PickDTO> doUpdateEntity(MyEntity3283Pick entity, MyEntity3283PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}