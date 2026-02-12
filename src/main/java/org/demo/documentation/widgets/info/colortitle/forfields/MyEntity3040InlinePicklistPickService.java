package org.demo.documentation.widgets.info.colortitle.forfields;

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
public class MyEntity3040InlinePicklistPickService extends VersionAwareResponseService<MyEntity3040InlinePicklistPickDTO, MyEntity3040InlinePicklist> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3040InlinePicklistPickMeta> meta = MyEntity3040InlinePicklistPickMeta.class;

	@Override
	protected CreateResult<MyEntity3040InlinePicklistPickDTO> doCreateEntity(MyEntity3040InlinePicklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3040InlinePicklistPickDTO> doUpdateEntity(MyEntity3040InlinePicklist entity, MyEntity3040InlinePicklistPickDTO data,
																				BusinessComponent bc) {
		return null;
	}


}