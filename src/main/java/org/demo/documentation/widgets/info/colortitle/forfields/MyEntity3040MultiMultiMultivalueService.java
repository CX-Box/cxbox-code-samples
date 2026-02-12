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
public class MyEntity3040MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3040MultiMultiMultivalueDTO, org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3040MultiMultiMultivalueMeta> meta = MyEntity3040MultiMultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3040MultiMultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3040MultiMultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040MultiMulti entity, MyEntity3040MultiMultiMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}