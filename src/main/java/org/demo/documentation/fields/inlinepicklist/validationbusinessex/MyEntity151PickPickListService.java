package org.demo.documentation.fields.inlinepicklist.validationbusinessex;

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
public class MyEntity151PickPickListService extends
		VersionAwareResponseService<MyEntity151PickDTO, org.demo.documentation.fields.inlinepicklist.validationbusinessex.picklist.MyEntity151> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity151PickPickListMeta> meta = MyEntity151PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity151PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.validationbusinessex.picklist.MyEntity151 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity151PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.validationbusinessex.picklist.MyEntity151 entity, MyEntity151PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}