package org.demo.documentation.fields.inlinepicklist.ro;

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
public class MyEntity138PickPickListService extends
		VersionAwareResponseService<MyEntity138PickDTO, org.demo.documentation.fields.inlinepicklist.ro.picklist.MyEntity138> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity138PickPickListMeta> meta = MyEntity138PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity138PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.ro.picklist.MyEntity138 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity138PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.ro.picklist.MyEntity138 entity, MyEntity138PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}