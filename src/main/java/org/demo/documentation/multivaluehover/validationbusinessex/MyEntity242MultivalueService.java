package org.demo.documentation.multivaluehover.validationbusinessex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity242MultivalueService extends VersionAwareResponseService<MyEntity242MultivalueDTO, MyEntity242> {

	public MyEntity242MultivalueService() {
		super(MyEntity242MultivalueDTO.class, MyEntity242.class, null, MyEntity242MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity242MultivalueDTO> doCreateEntity(MyEntity242 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity242MultivalueDTO> doUpdateEntity(MyEntity242 entity, MyEntity242MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}