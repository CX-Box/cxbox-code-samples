package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

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
public class MyEntity3268InlinePickPickService extends VersionAwareResponseService<MyEntity3268InlinePickPickDTO, MyEntity3268InlinePick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3268InlinePickPickMeta> meta = MyEntity3268InlinePickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3268InlinePickPickDTO> doCreateEntity(MyEntity3268InlinePick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3268InlinePickPickDTO> doUpdateEntity(MyEntity3268InlinePick entity, MyEntity3268InlinePickPickDTO data,
																			BusinessComponent bc) {
		return null;
	}


}