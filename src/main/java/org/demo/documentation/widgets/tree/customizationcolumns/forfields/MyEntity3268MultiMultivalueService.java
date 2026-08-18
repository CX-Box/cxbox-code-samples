package org.demo.documentation.widgets.tree.customizationcolumns.forfields;

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
public class MyEntity3268MultiMultivalueService extends VersionAwareResponseService<MyEntity3268MultiMultivalueDTO, MyEntity3268Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3268MultiMultivalueMeta> meta = MyEntity3268MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3268MultiMultivalueDTO> doCreateEntity(MyEntity3268Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3268MultiMultivalueDTO> doUpdateEntity(MyEntity3268Multi entity, MyEntity3268MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		return null;
	}


}