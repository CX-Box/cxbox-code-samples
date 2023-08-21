package org.demo.documentation.inlinepicklist.sorting;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity149PickPickListService extends
		VersionAwareResponseService<MyEntity149PickDTO, org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149> {

	public MyEntity149PickPickListService() {
		super(
				MyEntity149PickDTO.class,
				org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149.class,
				null,
				MyEntity149PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity149PickDTO> doCreateEntity(
			org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity149PickDTO> doUpdateEntity(
			org.demo.documentation.inlinepicklist.sorting.picklist.MyEntity149 entity, MyEntity149PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}