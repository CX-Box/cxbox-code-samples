package org.demo.documentation.widgets.picklist.customizationcolumns;

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
public class MyEntity3089PickPickService extends VersionAwareResponseService<MyEntity3089PickPickDTO, MyEntity3089Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3089PickPickMeta> meta = MyEntity3089PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3089PickPickDTO> doCreateEntity(MyEntity3089Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3089PickPickDTO> doUpdateEntity(MyEntity3089Pick entity, MyEntity3089PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}