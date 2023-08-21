package org.demo.documentation.inlinepicklist.basic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity132PickPickListService extends
		VersionAwareResponseService<MyEntity132PickDTO, org.demo.documentation.inlinepicklist.basic.picklist.MyEntity132> {

	public MyEntity132PickPickListService() {
		super(
				MyEntity132PickDTO.class,
				org.demo.documentation.inlinepicklist.basic.picklist.MyEntity132.class,
				null,
				MyEntity132PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity132PickDTO> doCreateEntity(
			org.demo.documentation.inlinepicklist.basic.picklist.MyEntity132 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity132PickDTO> doUpdateEntity(
			org.demo.documentation.inlinepicklist.basic.picklist.MyEntity132 entity, MyEntity132PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}