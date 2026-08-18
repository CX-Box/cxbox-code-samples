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
public class MyEntity3267MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3267MultiMultiMultivalueDTO, org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMulti> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3267MultiMultiMultivalueMeta> meta = MyEntity3267MultiMultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3267MultiMultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMulti entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3267MultiMultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.tree.colortitle.forfields.MyEntity3267MultiMulti entity, MyEntity3267MultiMultiMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}