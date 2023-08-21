package org.demo.documentation.multivalue.validationannotation;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity199MultivalueService extends VersionAwareResponseService<MyEntity199MultivalueDTO, MyEntity199> {

	public MyEntity199MultivalueService() {
		super(MyEntity199MultivalueDTO.class, MyEntity199.class, null, MyEntity199MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity199MultivalueDTO> doCreateEntity(MyEntity199 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity199MultivalueDTO> doUpdateEntity(MyEntity199 entity, MyEntity199MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}