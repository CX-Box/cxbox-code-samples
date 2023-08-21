package org.demo.documentation.multivaluero.validationbusinessex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity219MultivalueService extends VersionAwareResponseService<MyEntity219MultivalueDTO, MyEntity219> {

	public MyEntity219MultivalueService() {
		super(MyEntity219MultivalueDTO.class, MyEntity219.class, null, MyEntity219MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity219MultivalueDTO> doCreateEntity(MyEntity219 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity219MultivalueDTO> doUpdateEntity(MyEntity219 entity, MyEntity219MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}