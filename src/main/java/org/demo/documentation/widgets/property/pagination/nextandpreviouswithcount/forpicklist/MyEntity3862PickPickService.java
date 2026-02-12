package org.demo.documentation.widgets.property.pagination.nextandpreviouswithcount.forpicklist;

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
public class MyEntity3862PickPickService extends VersionAwareResponseService<MyEntity3862PickPickDTO, MyEntity3862Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3862PickPickMeta> meta = MyEntity3862PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3862PickPickDTO> doCreateEntity(MyEntity3862Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3862PickPickDTO> doUpdateEntity(MyEntity3862Pick entity, MyEntity3862PickPickDTO data,
																	  BusinessComponent bc) {
		return null;
	}


}