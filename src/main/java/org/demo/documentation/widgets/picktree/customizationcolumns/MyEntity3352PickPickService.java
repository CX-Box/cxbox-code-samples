package org.demo.documentation.widgets.picktree.customizationcolumns;

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
public class MyEntity3352PickPickService extends VersionAwareResponseService<MyEntity3352PickPickDTO, MyEntity3352Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3352PickPickMeta> meta = MyEntity3352PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3352PickPickDTO> doCreateEntity(MyEntity3352Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3352PickPickDTO> doUpdateEntity(MyEntity3352Pick entity, MyEntity3352PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}