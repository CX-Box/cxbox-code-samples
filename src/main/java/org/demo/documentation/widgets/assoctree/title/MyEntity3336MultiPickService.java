package org.demo.documentation.widgets.assoctree.title;

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
public class MyEntity3336MultiPickService extends VersionAwareResponseService<MyEntity3336MultiPickDTO, MyEntity3336Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3336MultiPickMeta> meta = MyEntity3336MultiPickMeta.class;

	@Override
	protected CreateResult<MyEntity3336MultiPickDTO> doCreateEntity(MyEntity3336Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3336MultiPickDTO> doUpdateEntity(MyEntity3336Multi entity, MyEntity3336MultiPickDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}