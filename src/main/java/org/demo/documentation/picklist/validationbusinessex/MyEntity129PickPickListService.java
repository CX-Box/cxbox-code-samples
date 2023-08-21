package org.demo.documentation.picklist.validationbusinessex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity129PickPickListService extends VersionAwareResponseService<MyEntity129PickDTO, MyEntity129> {

	public MyEntity129PickPickListService() {
		super(MyEntity129PickDTO.class, MyEntity129.class, null, MyEntity129PickPickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity129PickDTO> doCreateEntity(MyEntity129 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity129PickDTO> doUpdateEntity(MyEntity129 entity, MyEntity129PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}