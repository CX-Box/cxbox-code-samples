package org.demo.documentation.picklist.validationruntimeex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity131PickPickListService extends VersionAwareResponseService<MyEntity131PickDTO, MyEntity131> {

	public MyEntity131PickPickListService() {
		super(MyEntity131PickDTO.class, MyEntity131.class, null, MyEntity131PickPickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity131PickDTO> doCreateEntity(MyEntity131 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity131PickDTO> doUpdateEntity(MyEntity131 entity, MyEntity131PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}