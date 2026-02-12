package org.demo.documentation.widgets.formpopup.colortitle.forfields;

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
public class MyEntity3044PickService extends VersionAwareResponseService<MyEntity3044PickDTO, MyEntity3044> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3044PickMeta> meta = MyEntity3044PickMeta.class;

	@Override
	protected CreateResult<MyEntity3044PickDTO> doCreateEntity(MyEntity3044 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3044PickDTO> doUpdateEntity(MyEntity3044 entity, MyEntity3044PickDTO data,
																  BusinessComponent bc) {
		return null;
	}


}