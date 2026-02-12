package org.demo.documentation.widgets.property.excel.inner.forfields;

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
public class MyEntity3134InlinePickPickService extends VersionAwareResponseService<MyEntity3134InlinePickPickDTO, MyEntity3134InlinePick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3134InlinePickPickMeta> meta = MyEntity3134InlinePickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3134InlinePickPickDTO> doCreateEntity(MyEntity3134InlinePick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3134InlinePickPickDTO> doUpdateEntity(MyEntity3134InlinePick entity, MyEntity3134InlinePickPickDTO data,
																			BusinessComponent bc) {
		return null;
	}


}