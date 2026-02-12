package org.demo.documentation.fields.inlinepicklist.required;

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
public class MyEntity147PickPickListService extends
		VersionAwareResponseService<MyEntity147PickDTO, org.demo.documentation.fields.inlinepicklist.required.picklist.MyEntity147> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity147PickPickListMeta> meta = MyEntity147PickPickListMeta.class;

	@Override
	protected CreateResult<MyEntity147PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.required.picklist.MyEntity147 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity147PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.required.picklist.MyEntity147 entity, MyEntity147PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}