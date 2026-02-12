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
public class MyEntity3043PickService extends VersionAwareResponseService<MyEntity3043PickDTO, MyEntity3043> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3043PickMeta> meta = MyEntity3043PickMeta.class;

	@Override
	protected CreateResult<MyEntity3043PickDTO> doCreateEntity(MyEntity3043 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3043PickDTO> doUpdateEntity(MyEntity3043 entity, MyEntity3043PickDTO data,
																  BusinessComponent bc) {
		return null;
	}


}