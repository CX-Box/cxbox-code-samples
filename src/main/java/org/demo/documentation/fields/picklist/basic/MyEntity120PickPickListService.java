package org.demo.documentation.fields.picklist.basic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity120PickPickListService extends VersionAwareResponseService<MyEntity120PickDTO, MyEntityPick120> {

	public MyEntity120PickPickListService() {
		super(MyEntity120PickDTO.class, MyEntityPick120.class, null, MyEntity120PickPickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity120PickDTO> doCreateEntity(MyEntityPick120 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity120PickDTO> doUpdateEntity(MyEntityPick120 entity, MyEntity120PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}