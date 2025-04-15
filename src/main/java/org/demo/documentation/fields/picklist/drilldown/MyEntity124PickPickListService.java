package org.demo.documentation.fields.picklist.drilldown;

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
public class MyEntity124PickPickListService extends VersionAwareResponseService<MyEntity124PickDTO, MyEntity124> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity124PickPickListMeta> meta = MyEntity124PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity124PickDTO> doCreateEntity(MyEntity124 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity124PickDTO> doUpdateEntity(MyEntity124 entity, MyEntity124PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}