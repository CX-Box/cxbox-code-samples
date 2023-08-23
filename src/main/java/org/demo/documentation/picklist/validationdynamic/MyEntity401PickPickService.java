package org.demo.documentation.picklist.validationdynamic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity401PickPickService extends VersionAwareResponseService<MyEntity401PickPickDTO, MyEntity401Pick> {

	public MyEntity401PickPickService() {
		super(MyEntity401PickPickDTO.class, MyEntity401Pick.class, null, MyEntity401PickPickMeta.class);
	}

	@Override
	protected CreateResult<MyEntity401PickPickDTO> doCreateEntity(MyEntity401Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity401PickPickDTO> doUpdateEntity(MyEntity401Pick entity, MyEntity401PickPickDTO data,
			BusinessComponent bc) {
		return null;
	}


}