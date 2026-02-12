package org.demo.documentation.widgets.formpopup.base.onefield.forfields;

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
public class MyEntity3400InlinePicklistPickService extends VersionAwareResponseService<MyEntity3400InlinePicklistPickDTO, MyEntity3400InlinePicklist> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3400InlinePicklistPickMeta> meta = MyEntity3400InlinePicklistPickMeta.class;

	@Override
	protected CreateResult<MyEntity3400InlinePicklistPickDTO> doCreateEntity(MyEntity3400InlinePicklist entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3400InlinePicklistPickDTO> doUpdateEntity(MyEntity3400InlinePicklist entity, MyEntity3400InlinePicklistPickDTO data,
																				BusinessComponent bc) {
		return null;
	}


}