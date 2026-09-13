package org.demo.documentation.fields.picktree.ro;

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
public class MyEntity3289PickPickTreeService extends VersionAwareResponseService<MyEntity3289PickDTO, MyEntity3289Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3289PickPickTreeMeta> meta = MyEntity3289PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3289PickDTO> doCreateEntity(MyEntity3289Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3289PickDTO> doUpdateEntity(MyEntity3289Pick entity, MyEntity3289PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}