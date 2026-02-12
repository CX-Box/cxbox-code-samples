package org.demo.documentation.widgets.picklist.base.allfields;

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
public class MyEntity3067MultiPickService extends VersionAwareResponseService<MyEntity3067MultiPickDTO, org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3067MultiPickMeta> meta = MyEntity3067MultiPickMeta.class;

	@Override
	protected CreateResult<MyEntity3067MultiPickDTO> doCreateEntity(org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3067MultiPickDTO> doUpdateEntity(org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi entity, MyEntity3067MultiPickDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}