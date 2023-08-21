package org.demo.documentation.picklist.validationdynamic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity330PickPickListService extends VersionAwareResponseService<MyEntity330PickDTO, MyEntity330> {

	public MyEntity330PickPickListService() {
		super(MyEntity330PickDTO.class, MyEntity330.class, null, MyEntity330PickPickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity330PickDTO> doCreateEntity(MyEntity330 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity330PickDTO> doUpdateEntity(MyEntity330 entity, MyEntity330PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}