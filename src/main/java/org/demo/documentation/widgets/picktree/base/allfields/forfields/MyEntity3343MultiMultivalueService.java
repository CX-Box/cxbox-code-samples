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
public class MyEntity3343MultiMultivalueService extends VersionAwareResponseService<MyEntity3343MultiMultivalueDTO, MyEntity3343Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3343MultiMultivalueMeta> meta = MyEntity3343MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3343MultiMultivalueDTO> doCreateEntity(MyEntity3343Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3343MultiMultivalueDTO> doUpdateEntity(MyEntity3343Multi entity, MyEntity3343MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		return null;
	}


}