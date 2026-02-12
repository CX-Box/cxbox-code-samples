package org.demo.documentation.fields.picklist.ro;

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
public class MyEntity123PickPickListService extends VersionAwareResponseService<MyEntity123PickDTO, MyEntity123> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity123PickPickListMeta> meta = MyEntity123PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity123PickDTO> doCreateEntity(MyEntity123 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity123PickDTO> doUpdateEntity(MyEntity123 entity, MyEntity123PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}