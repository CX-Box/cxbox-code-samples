package org.demo.documentation.fields.picktree.sorting;

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
public class MyEntity3290PickPickTreeService extends VersionAwareResponseService<MyEntity3290PickDTO, MyEntity3290Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3290PickPickTreeMeta> meta = MyEntity3290PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3290PickDTO> doCreateEntity(MyEntity3290Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3290PickDTO> doUpdateEntity(MyEntity3290Pick entity, MyEntity3290PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}