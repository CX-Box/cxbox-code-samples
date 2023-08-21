package org.demo.documentation.inlinepicklist.required;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity147PickPickListService extends
		VersionAwareResponseService<MyEntity147PickDTO, org.demo.documentation.inlinepicklist.required.picklist.MyEntity147> {

	public MyEntity147PickPickListService() {
		super(
				MyEntity147PickDTO.class,
				org.demo.documentation.inlinepicklist.required.picklist.MyEntity147.class,
				null,
				MyEntity147PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity147PickDTO> doCreateEntity(
			org.demo.documentation.inlinepicklist.required.picklist.MyEntity147 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity147PickDTO> doUpdateEntity(
			org.demo.documentation.inlinepicklist.required.picklist.MyEntity147 entity, MyEntity147PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}