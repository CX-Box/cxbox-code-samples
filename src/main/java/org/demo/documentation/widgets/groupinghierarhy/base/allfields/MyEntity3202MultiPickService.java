package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

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
public class MyEntity3202MultiPickService extends VersionAwareResponseService<MyEntity3202MultiPickDTO, MyEntity3202Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3202MultiPickMeta> meta = MyEntity3202MultiPickMeta.class;

	@Override
	protected CreateResult<MyEntity3202MultiPickDTO> doCreateEntity(MyEntity3202Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3202MultiPickDTO> doUpdateEntity(MyEntity3202Multi entity, MyEntity3202MultiPickDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}