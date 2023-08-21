package org.demo.documentation.inlinepicklist.validationdynamic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity327PickListService extends VersionAwareResponseService<MyEntity327PickDTO, MyEntity327> {

	public MyEntity327PickListService() {
		super(MyEntity327PickDTO.class, MyEntity327.class, null, MyEntity327PickListMeta.class);
	}

	@Override
	protected CreateResult<MyEntity327PickDTO> doCreateEntity(MyEntity327 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity327PickDTO> doUpdateEntity(MyEntity327 entity, MyEntity327PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}