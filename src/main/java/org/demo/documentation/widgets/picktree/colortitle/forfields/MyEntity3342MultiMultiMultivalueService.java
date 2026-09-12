package org.demo.documentation.widgets.picktree.colortitle.forfields;

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
public class MyEntity3342MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3342MultiMultiMultivalueDTO, org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342MultiMulti> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3342MultiMultiMultivalueMeta> meta = MyEntity3342MultiMultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3342MultiMultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342MultiMulti entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3342MultiMultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342MultiMulti entity, MyEntity3342MultiMultiMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}