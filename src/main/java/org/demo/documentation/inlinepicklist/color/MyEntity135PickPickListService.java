package org.demo.documentation.inlinepicklist.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity135PickPickListService extends
		VersionAwareResponseService<MyEntity135PickDTO, org.demo.documentation.inlinepicklist.color.picklist.MyEntity135> {

	public MyEntity135PickPickListService() {
		super(
				MyEntity135PickDTO.class,
				org.demo.documentation.inlinepicklist.color.picklist.MyEntity135.class,
				null,
				MyEntity135PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity135PickDTO> doCreateEntity(
			org.demo.documentation.inlinepicklist.color.picklist.MyEntity135 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity135PickDTO> doUpdateEntity(
			org.demo.documentation.inlinepicklist.color.picklist.MyEntity135 entity, MyEntity135PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}