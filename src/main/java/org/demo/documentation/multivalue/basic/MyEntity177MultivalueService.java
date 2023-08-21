package org.demo.documentation.multivalue.basic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity177MultivalueService extends VersionAwareResponseService<MyEntity177MultivalueDTO, MyEntity177> {

	public MyEntity177MultivalueService() {
		super(MyEntity177MultivalueDTO.class, MyEntity177.class, null, MyEntity177MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity177MultivalueDTO> doCreateEntity(MyEntity177 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity177MultivalueDTO> doUpdateEntity(MyEntity177 entity, MyEntity177MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}