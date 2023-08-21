package org.demo.documentation.picklist.ro;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity123PickPickListService extends VersionAwareResponseService<MyEntity123PickDTO, MyEntity123> {

	public MyEntity123PickPickListService() {
		super(MyEntity123PickDTO.class, MyEntity123.class, null, MyEntity123PickPickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity123PickDTO> doCreateEntity(MyEntity123 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity123PickDTO> doUpdateEntity(MyEntity123 entity, MyEntity123PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}