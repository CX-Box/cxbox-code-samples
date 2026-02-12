package org.demo.documentation.widgets.picklist.base.allfields.forfields;

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
public class MyEntity3067MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3067MultiMultiMultivalueDTO, MyEntity3067MultiMulti> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3067MultiMultiMultivalueMeta> meta = MyEntity3067MultiMultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3067MultiMultiMultivalueDTO> doCreateEntity(MyEntity3067MultiMulti entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3067MultiMultiMultivalueDTO> doUpdateEntity(MyEntity3067MultiMulti entity, MyEntity3067MultiMultiMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}