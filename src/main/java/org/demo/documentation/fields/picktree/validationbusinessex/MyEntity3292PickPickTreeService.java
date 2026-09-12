package org.demo.documentation.fields.picktree.validationbusinessex;

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
public class MyEntity3292PickPickTreeService extends VersionAwareResponseService<MyEntity3292PickDTO, MyEntity3292Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3292PickPickTreeMeta> meta = MyEntity3292PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3292PickDTO> doCreateEntity(MyEntity3292Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3292PickDTO> doUpdateEntity(MyEntity3292Pick entity, MyEntity3292PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}