package org.demo.documentation.fields.picklist.colorconst;

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
public class MyEntity122PickPickListService extends VersionAwareResponseService<MyEntity122PickDTO, MyEntity122> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity122PickPickListMeta> meta = MyEntity122PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity122PickDTO> doCreateEntity(MyEntity122 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity122PickDTO> doUpdateEntity(MyEntity122 entity, MyEntity122PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}