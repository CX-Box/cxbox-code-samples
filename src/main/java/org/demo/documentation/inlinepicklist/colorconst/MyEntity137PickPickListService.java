package org.demo.documentation.inlinepicklist.colorconst;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity137PickPickListService extends
		VersionAwareResponseService<MyEntity137PickDTO, org.demo.documentation.inlinepicklist.colorconst.picklist.MyEntity137> {

	public MyEntity137PickPickListService() {
		super(
				MyEntity137PickDTO.class,
				org.demo.documentation.inlinepicklist.colorconst.picklist.MyEntity137.class,
				null,
				MyEntity137PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity137PickDTO> doCreateEntity(
			org.demo.documentation.inlinepicklist.colorconst.picklist.MyEntity137 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity137PickDTO> doUpdateEntity(
			org.demo.documentation.inlinepicklist.colorconst.picklist.MyEntity137 entity, MyEntity137PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}