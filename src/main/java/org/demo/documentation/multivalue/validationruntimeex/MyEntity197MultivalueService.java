package org.demo.documentation.multivalue.validationruntimeex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity197MultivalueService extends VersionAwareResponseService<MyEntity197MultivalueDTO, MyEntity197> {

	public MyEntity197MultivalueService() {
		super(MyEntity197MultivalueDTO.class, MyEntity197.class, null, MyEntity197MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity197MultivalueDTO> doCreateEntity(MyEntity197 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity197MultivalueDTO> doUpdateEntity(MyEntity197 entity, MyEntity197MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}