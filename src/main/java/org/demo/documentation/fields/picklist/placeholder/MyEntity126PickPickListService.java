package org.demo.documentation.fields.picklist.placeholder;

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
public class MyEntity126PickPickListService extends VersionAwareResponseService<MyEntity126PickDTO, MyEntity126> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity126PickPickListMeta> meta = MyEntity126PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity126PickDTO> doCreateEntity(MyEntity126 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity126PickDTO> doUpdateEntity(MyEntity126 entity, MyEntity126PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}