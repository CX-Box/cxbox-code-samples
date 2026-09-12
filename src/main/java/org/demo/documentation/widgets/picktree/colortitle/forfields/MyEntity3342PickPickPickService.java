package org.demo.documentation.widgets.picktree.colortitle.forfields;

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
public class MyEntity3342PickPickPickService extends VersionAwareResponseService<MyEntity3342PickPickPickDTO, MyEntity3342PickPick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3342PickPickPickMeta> meta = MyEntity3342PickPickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3342PickPickPickDTO> doCreateEntity(MyEntity3342PickPick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3342PickPickPickDTO> doUpdateEntity(MyEntity3342PickPick entity, MyEntity3342PickPickPickDTO data,
																		  BusinessComponent bc) {
		return null;
	}


}