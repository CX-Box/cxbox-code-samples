package org.demo.documentation.widgets.picktree.fieldslayoute;

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
public class MyEntity3346PickPickService extends VersionAwareResponseService<MyEntity3346PickPickDTO, MyEntity3346Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3346PickPickMeta> meta = MyEntity3346PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3346PickPickDTO> doCreateEntity(MyEntity3346Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3346PickPickDTO> doUpdateEntity(MyEntity3346Pick entity, MyEntity3346PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}