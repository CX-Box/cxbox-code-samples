package org.demo.documentation.widgets.tree.colortitle.forfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Multi;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3267MultiMultivalueService extends VersionAwareResponseService<MyEntity3267MultiMultivalueDTO, Myexample3262Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3267MultiMultivalueMeta> meta = MyEntity3267MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3267MultiMultivalueDTO> doCreateEntity(Myexample3262Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3267MultiMultivalueDTO> doUpdateEntity(Myexample3262Multi entity, MyEntity3267MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		return null;
	}


}