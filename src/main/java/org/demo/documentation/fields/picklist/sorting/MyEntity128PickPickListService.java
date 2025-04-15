package org.demo.documentation.fields.picklist.sorting;

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
public class MyEntity128PickPickListService extends VersionAwareResponseService<MyEntity128PickDTO, MyEntity128> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity128PickPickListMeta> meta = MyEntity128PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity128PickDTO> doCreateEntity(MyEntity128 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity128PickDTO> doUpdateEntity(MyEntity128 entity, MyEntity128PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}