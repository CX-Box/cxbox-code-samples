package org.demo.documentation.picklist.validationannotation;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity297PickService extends VersionAwareResponseService<MyEntity297PickDTO, MyEntity297> {

	public MyEntity297PickService() {
		super(MyEntity297PickDTO.class, MyEntity297.class, null, MyEntity297PickMeta.class);
	}

	@Override
	protected CreateResult<MyEntity297PickDTO> doCreateEntity(MyEntity297 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity297PickDTO> doUpdateEntity(MyEntity297 entity, MyEntity297PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}