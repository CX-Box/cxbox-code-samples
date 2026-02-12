package org.demo.documentation.fields.inlinepicklist.color;

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
public class MyEntity135PickPickListService extends
		VersionAwareResponseService<MyEntity135PickDTO, org.demo.documentation.fields.inlinepicklist.color.picklist.MyEntity135> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity135PickPickListMeta> meta = MyEntity135PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity135PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.color.picklist.MyEntity135 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity135PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.color.picklist.MyEntity135 entity, MyEntity135PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}