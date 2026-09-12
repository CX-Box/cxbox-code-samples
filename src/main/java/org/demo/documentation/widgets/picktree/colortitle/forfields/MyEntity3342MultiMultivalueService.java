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
public class MyEntity3342MultiMultivalueService extends VersionAwareResponseService<MyEntity3342MultiMultivalueDTO, org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3342MultiMultivalueMeta> meta = MyEntity3342MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3342MultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3342MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.picktree.colortitle.forfields.MyEntity3342Multi entity, MyEntity3342MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		return null;
	}


}