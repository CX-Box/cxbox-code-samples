package org.demo.documentation.fields.picklist.required;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity127PickPickListService extends VersionAwareResponseService<MyEntity127PickDTO, MyEntity127> {

	public MyEntity127PickPickListService() {
		super(MyEntity127PickDTO.class, MyEntity127.class, null, MyEntity127PickPickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity127PickDTO> doCreateEntity(MyEntity127 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity127PickDTO> doUpdateEntity(MyEntity127 entity, MyEntity127PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}