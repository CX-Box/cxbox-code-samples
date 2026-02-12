package org.demo.documentation.widgets.assoc.title;

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
public class MyEntity3090MultiPickService extends VersionAwareResponseService<MyEntity3090MultiPickDTO, MyEntity3090Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3090MultiPickMeta> meta = MyEntity3090MultiPickMeta.class;

	@Override
	protected CreateResult<MyEntity3090MultiPickDTO> doCreateEntity(MyEntity3090Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3090MultiPickDTO> doUpdateEntity(MyEntity3090Multi entity, MyEntity3090MultiPickDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}