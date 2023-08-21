package org.demo.documentation.picklist.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity121PickPickListService extends VersionAwareResponseService<MyEntity121PickDTO, MyEntity121> {

	public MyEntity121PickPickListService() {
		super(MyEntity121PickDTO.class, MyEntity121.class, null, MyEntity121PickPickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity121PickDTO> doCreateEntity(MyEntity121 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity121PickDTO> doUpdateEntity(MyEntity121 entity, MyEntity121PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}