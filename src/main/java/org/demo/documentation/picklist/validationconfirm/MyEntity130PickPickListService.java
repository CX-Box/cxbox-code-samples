package org.demo.documentation.picklist.validationconfirm;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity130PickPickListService extends VersionAwareResponseService<MyEntity130PickDTO, MyEntity130> {

	public MyEntity130PickPickListService() {
		super(MyEntity130PickDTO.class, MyEntity130.class, null, MyEntity130PickPickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity130PickDTO> doCreateEntity(MyEntity130 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity130PickDTO> doUpdateEntity(MyEntity130 entity, MyEntity130PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}