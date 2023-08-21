package org.demo.documentation.inlinepicklist.validationbusinessex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity151PickPickListService extends
		VersionAwareResponseService<MyEntity151PickDTO, org.demo.documentation.inlinepicklist.validationbusinessex.picklist.MyEntity151> {

	public MyEntity151PickPickListService() {
		super(
				MyEntity151PickDTO.class,
				org.demo.documentation.inlinepicklist.validationbusinessex.picklist.MyEntity151.class,
				null,
				MyEntity151PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity151PickDTO> doCreateEntity(
			org.demo.documentation.inlinepicklist.validationbusinessex.picklist.MyEntity151 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity151PickDTO> doUpdateEntity(
			org.demo.documentation.inlinepicklist.validationbusinessex.picklist.MyEntity151 entity, MyEntity151PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}