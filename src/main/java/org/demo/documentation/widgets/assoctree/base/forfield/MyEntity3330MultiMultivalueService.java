package org.demo.documentation.widgets.assoctree.base.forfield;

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
public class MyEntity3330MultiMultivalueService extends VersionAwareResponseService<MyEntity3330MultiMultivalueDTO, org.demo.documentation.widgets.assoctree.base.forfield.MyEntity3330Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3330MultiMultivalueMeta> meta = MyEntity3330MultiMultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3330MultiMultivalueDTO> doCreateEntity(MyEntity3330Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3330MultiMultivalueDTO> doUpdateEntity(MyEntity3330Multi entity, MyEntity3330MultiMultivalueDTO data,
																			 BusinessComponent bc) {
		setIfChanged(data, MyEntity3330MultiMultivalueDTO_.customFieldNew, entity::setCustomFieldNew);
		return null;
	}


}