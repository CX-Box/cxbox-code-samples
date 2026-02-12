package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

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
public class MyEntity3175InlinePickPickService extends VersionAwareResponseService<MyEntity3175InlinePickPickDTO, MyEntity3175InlinePick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3175InlinePickPickMeta> meta = MyEntity3175InlinePickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3175InlinePickPickDTO> doCreateEntity(MyEntity3175InlinePick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3175InlinePickPickDTO> doUpdateEntity(MyEntity3175InlinePick entity, MyEntity3175InlinePickPickDTO data,
																			BusinessComponent bc) {
		return null;
	}


}