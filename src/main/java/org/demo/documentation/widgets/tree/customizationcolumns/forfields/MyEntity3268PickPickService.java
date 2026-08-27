package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Pick;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3268PickPickService extends VersionAwareResponseService<MyEntity3268PickPickDTO, Myexample3262Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3268PickPickMeta> meta = MyEntity3268PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3268PickPickDTO> doCreateEntity(Myexample3262Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3268PickPickDTO> doUpdateEntity(Myexample3262Pick entity, MyEntity3268PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}