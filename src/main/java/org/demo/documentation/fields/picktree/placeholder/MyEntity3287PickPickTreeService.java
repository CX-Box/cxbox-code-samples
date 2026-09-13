package org.demo.documentation.fields.picktree.placeholder;

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
public class MyEntity3287PickPickTreeService extends VersionAwareResponseService<MyEntity3287PickDTO, MyEntity3287Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3287PickPickTreeMeta> meta = MyEntity3287PickPickTreeMeta.class;

	@Override
	protected CreateResult<MyEntity3287PickDTO> doCreateEntity(MyEntity3287Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3287PickDTO> doUpdateEntity(MyEntity3287Pick entity, MyEntity3287PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}