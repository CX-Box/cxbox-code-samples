package org.demo.documentation.widgets.picklist.colortitle.forfields;

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
public class MyEntity3061MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3061MultiMultiMultivalueDTO, org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061MultiMulti> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3061MultiMultiMultivalueMeta> meta = MyEntity3061MultiMultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3061MultiMultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061MultiMulti entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3061MultiMultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061MultiMulti entity, MyEntity3061MultiMultiMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}