package org.demo.documentation.widgets.info.base.allfields.forfields;

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
public class MyEntity4222PickPickService extends VersionAwareResponseService<MyEntity4222PickPickDTO, MyEntity4222Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity4222PickPickMeta> meta = MyEntity4222PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity4222PickPickDTO> doCreateEntity(MyEntity4222Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity4222PickPickDTO> doUpdateEntity(MyEntity4222Pick entity, MyEntity4222PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}