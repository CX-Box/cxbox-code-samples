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
public class MyEntity4222Pick2PickService extends VersionAwareResponseService<MyEntity4222Pick2PickDTO, MyEntity4222Pick2> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity4222Pick2PickMeta> meta = MyEntity4222Pick2PickMeta.class;

	@Override
	protected CreateResult<MyEntity4222Pick2PickDTO> doCreateEntity(MyEntity4222Pick2 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity4222Pick2PickDTO> doUpdateEntity(MyEntity4222Pick2 entity, MyEntity4222Pick2PickDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}