package org.demo.documentation.widgets.form.colortitle.forfields;

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
public class MyEntity3033MultivalueService extends VersionAwareResponseService<MyEntity3033MultivalueDTO, MyEntity3033> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3033MultivalueMeta> meta = MyEntity3033MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3033MultivalueDTO> doCreateEntity(MyEntity3033 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3033MultivalueDTO> doUpdateEntity(MyEntity3033 entity, MyEntity3033MultivalueDTO data,
																		BusinessComponent bc) {
		return null;
	}


}