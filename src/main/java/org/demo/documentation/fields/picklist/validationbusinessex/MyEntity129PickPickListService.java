package org.demo.documentation.fields.picklist.validationbusinessex;

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
public class MyEntity129PickPickListService extends VersionAwareResponseService<MyEntity129PickDTO, MyEntity129> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity129PickPickListMeta> meta = MyEntity129PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity129PickDTO> doCreateEntity(MyEntity129 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity129PickDTO> doUpdateEntity(MyEntity129 entity, MyEntity129PickDTO data,
																 BusinessComponent bc) {
		return null;
	}


}