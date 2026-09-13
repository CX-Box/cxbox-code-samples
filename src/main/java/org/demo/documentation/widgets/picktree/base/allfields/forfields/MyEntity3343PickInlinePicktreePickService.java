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
public class MyEntity3343PickInlinePicktreePickService extends VersionAwareResponseService<MyEntity3343PickInlinePicktreePickDTO, MyEntity3343PickInlinePicktree> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3343PickInlinePicktreePickMeta> meta = MyEntity3343PickInlinePicktreePickMeta.class;

	@Override
	protected CreateResult<MyEntity3343PickInlinePicktreePickDTO> doCreateEntity(MyEntity3343PickInlinePicktree entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3343PickInlinePicktreePickDTO> doUpdateEntity(MyEntity3343PickInlinePicktree entity, MyEntity3343PickInlinePicktreePickDTO data,
																					BusinessComponent bc) {
		return null;
	}


}