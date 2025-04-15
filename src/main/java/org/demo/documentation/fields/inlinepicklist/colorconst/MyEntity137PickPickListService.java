package org.demo.documentation.fields.inlinepicklist.colorconst;

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
public class MyEntity137PickPickListService extends
		VersionAwareResponseService<MyEntity137PickDTO, org.demo.documentation.fields.inlinepicklist.colorconst.picklist.MyEntity137> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity137PickPickListMeta> meta = MyEntity137PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity137PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.colorconst.picklist.MyEntity137 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity137PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.colorconst.picklist.MyEntity137 entity, MyEntity137PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}