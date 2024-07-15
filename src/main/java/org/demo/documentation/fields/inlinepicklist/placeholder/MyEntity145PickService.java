package org.demo.documentation.fields.inlinepicklist.placeholder;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.demo.documentation.fields.inlinepicklist.placeholder.picklist.MyEntity145;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity145PickService extends VersionAwareResponseService<MyEntity145PickDTO, MyEntity145> {

	public MyEntity145PickService() {
		super(MyEntity145PickDTO.class, MyEntity145.class, null, MyEntity145PickMeta.class);
	}

	@Override
	protected CreateResult<MyEntity145PickDTO> doCreateEntity(MyEntity145 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity145PickDTO> doUpdateEntity(MyEntity145 entity, MyEntity145PickDTO data,
			BusinessComponent bc) {
		return null;
	}


}