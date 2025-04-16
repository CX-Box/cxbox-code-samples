package org.demo.documentation.fields.inlinepicklist.drilldown;

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
public class MyEntity141PickPickListService extends
		VersionAwareResponseService<MyEntity141PickDTO, org.demo.documentation.fields.inlinepicklist.drilldown.picklist.MyEntity141> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity141PickPickListMeta> meta = MyEntity141PickPickListMeta.class;

    @Override
	protected CreateResult<MyEntity141PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.drilldown.picklist.MyEntity141 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity141PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.drilldown.picklist.MyEntity141 entity, MyEntity141PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}