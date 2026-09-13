package org.demo.documentation.fields.picktree.colorconst;

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
public class MyEntity3284PickPickTreeService extends VersionAwareResponseService<MyEntity3284PickDTO, MyEntity3284Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3284PickPickTreeMeta> meta = MyEntity3284PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3284PickDTO> doCreateEntity(MyEntity3284Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3284PickDTO> doUpdateEntity(MyEntity3284Pick entity, MyEntity3284PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}