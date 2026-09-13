package org.demo.documentation.widgets.picktree.base.allfields.forfields;

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
public class MyEntity3343MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3343MultiMultiMultivalueDTO, MyEntity3343MultiMulti> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3343MultiMultiMultivalueMeta> meta = MyEntity3343MultiMultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3343MultiMultiMultivalueDTO> doCreateEntity(MyEntity3343MultiMulti entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3343MultiMultiMultivalueDTO> doUpdateEntity(MyEntity3343MultiMulti entity, MyEntity3343MultiMultiMultivalueDTO data,
																				  BusinessComponent bc) {
		return null;
	}


}