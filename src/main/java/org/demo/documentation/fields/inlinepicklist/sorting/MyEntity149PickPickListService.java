package org.demo.documentation.fields.inlinepicklist.sorting;

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
public class MyEntity149PickPickListService extends
		VersionAwareResponseService<MyEntity149PickDTO, org.demo.documentation.fields.inlinepicklist.sorting.picklist.MyEntity149> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity149PickPickListMeta> meta = MyEntity149PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity149PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.sorting.picklist.MyEntity149 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity149PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.sorting.picklist.MyEntity149 entity, MyEntity149PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}