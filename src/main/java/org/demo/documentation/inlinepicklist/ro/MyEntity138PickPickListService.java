package org.demo.documentation.inlinepicklist.ro;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity138PickPickListService extends
		VersionAwareResponseService<MyEntity138PickDTO, org.demo.documentation.inlinepicklist.ro.picklist.MyEntity138> {

	public MyEntity138PickPickListService() {
		super(
				MyEntity138PickDTO.class,
				org.demo.documentation.inlinepicklist.ro.picklist.MyEntity138.class,
				null,
				MyEntity138PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity138PickDTO> doCreateEntity(
			org.demo.documentation.inlinepicklist.ro.picklist.MyEntity138 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity138PickDTO> doUpdateEntity(
			org.demo.documentation.inlinepicklist.ro.picklist.MyEntity138 entity, MyEntity138PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}