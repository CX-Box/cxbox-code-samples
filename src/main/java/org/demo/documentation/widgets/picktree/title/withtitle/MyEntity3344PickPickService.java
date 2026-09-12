package org.demo.documentation.widgets.picktree.title.withtitle;

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
public class MyEntity3344PickPickService extends VersionAwareResponseService<MyEntity3344PickPickDTO, MyEntity3344Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3344PickPickMeta> meta = MyEntity3344PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3344PickPickDTO> doCreateEntity(MyEntity3344Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3344PickPickDTO> doUpdateEntity(MyEntity3344Pick entity, MyEntity3344PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}