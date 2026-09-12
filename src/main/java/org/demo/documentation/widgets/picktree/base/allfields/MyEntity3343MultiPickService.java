package org.demo.documentation.widgets.picktree.base.allfields;

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
public class MyEntity3343MultiPickService extends VersionAwareResponseService<MyEntity3343MultiPickDTO, org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3343MultiPickMeta> meta = MyEntity3343MultiPickMeta.class;

	@Override
	protected CreateResult<MyEntity3343MultiPickDTO> doCreateEntity(org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3343MultiPickDTO> doUpdateEntity(org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi entity, MyEntity3343MultiPickDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}