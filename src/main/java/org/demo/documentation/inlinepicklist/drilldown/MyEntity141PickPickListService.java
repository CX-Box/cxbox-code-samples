package org.demo.documentation.inlinepicklist.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity141PickPickListService extends
		VersionAwareResponseService<MyEntity141PickDTO, org.demo.documentation.inlinepicklist.drilldown.picklist.MyEntity141> {

	public MyEntity141PickPickListService() {
		super(
				MyEntity141PickDTO.class,
				org.demo.documentation.inlinepicklist.drilldown.picklist.MyEntity141.class,
				null,
				MyEntity141PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity141PickDTO> doCreateEntity(
			org.demo.documentation.inlinepicklist.drilldown.picklist.MyEntity141 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity141PickDTO> doUpdateEntity(
			org.demo.documentation.inlinepicklist.drilldown.picklist.MyEntity141 entity, MyEntity141PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}