package org.demo.documentation.widgets.tree.colortitle.forfields;

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
public class MyEntity3267InlinePicklistPickService extends VersionAwareResponseService<MyEntity3267InlinePicklistPickDTO, MyEntity3267InlinePicklist> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3267InlinePicklistPickMeta> meta = MyEntity3267InlinePicklistPickMeta.class;

	@Override
	protected CreateResult<MyEntity3267InlinePicklistPickDTO> doCreateEntity(MyEntity3267InlinePicklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3267InlinePicklistPickDTO> doUpdateEntity(MyEntity3267InlinePicklist entity, MyEntity3267InlinePicklistPickDTO data,
																				BusinessComponent bc) {
		return null;
	}


}