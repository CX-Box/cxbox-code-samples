package org.demo.documentation.fields.inlinepicklist.validationruntimeex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity155PickPickListService extends
		VersionAwareResponseService<MyEntity155PickDTO, org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155> {

	public MyEntity155PickPickListService() {
		super(
				MyEntity155PickDTO.class,
				org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155.class,
				null,
				MyEntity155PickPickListMeta.class
		);
	}

	@Override
	protected CreateResult<MyEntity155PickDTO> doCreateEntity(
			org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity155PickDTO> doUpdateEntity(
			org.demo.documentation.fields.inlinepicklist.validationruntimeex.picklist.MyEntity155 entity, MyEntity155PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}