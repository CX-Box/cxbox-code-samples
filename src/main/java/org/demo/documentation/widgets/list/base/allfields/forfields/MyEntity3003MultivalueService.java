package org.demo.documentation.widgets.list.base.allfields.forfields;

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
public class MyEntity3003MultivalueService extends VersionAwareResponseService<MyEntity3003MultivalueDTO, org.demo.documentation.widgets.form.title.MyEntity3003> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3003MultivalueMeta> meta = MyEntity3003MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3003MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.form.title.MyEntity3003 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3003MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.form.title.MyEntity3003 entity, MyEntity3003MultivalueDTO data,
																		BusinessComponent bc) {
		return null;
	}


}