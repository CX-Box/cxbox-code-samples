package org.demo.documentation.fields.inlinepicklist.validationconfirm;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity153PickPickListService extends
		VersionAwareResponseService<MyEntity153PickDTO, org.demo.documentation.fields.inlinepicklist.validationconfirm.picklist.MyEntity153> {

	public MyEntity153PickPickListService() {
		super(
				MyEntity153PickDTO.class,
				org.demo.documentation.fields.inlinepicklist.validationconfirm.picklist.MyEntity153.class,
				null,
				MyEntity153PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity153PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.validationconfirm.picklist.MyEntity153 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity153PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.validationconfirm.picklist.MyEntity153 entity, MyEntity153PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}