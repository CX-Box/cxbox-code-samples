package org.demo.documentation.widgets.picktree.base.allfields.forfields;

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
public class MyEntity3343PickPicktreePickService extends VersionAwareResponseService<MyEntity3343PickPicktreePickDTO, MyEntity3343PickPicktree> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3343PickPicktreePickMeta> meta = MyEntity3343PickPicktreePickMeta.class;

	@Override
	protected CreateResult<MyEntity3343PickPicktreePickDTO> doCreateEntity(MyEntity3343PickPicktree entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3343PickPicktreePickDTO> doUpdateEntity(MyEntity3343PickPicktree entity, MyEntity3343PickPicktreePickDTO data,
																			  BusinessComponent bc) {
		return null;
	}


}