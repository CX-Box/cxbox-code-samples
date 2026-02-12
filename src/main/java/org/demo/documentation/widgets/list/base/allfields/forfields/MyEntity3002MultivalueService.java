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
public class MyEntity3002MultivalueService extends VersionAwareResponseService<MyEntity3002MultivalueDTO, MyEntity3002Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3002MultivalueMeta> meta = MyEntity3002MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3002MultivalueDTO> doCreateEntity(MyEntity3002Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3002MultivalueDTO> doUpdateEntity(MyEntity3002Multi entity, MyEntity3002MultivalueDTO data,
																		BusinessComponent bc) {
		return null;
	}


}