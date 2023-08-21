package org.demo.documentation.multivaluero.validationruntimeex;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity222MultivalueService extends VersionAwareResponseService<MyEntity222MultivalueDTO, MyEntity222> {

	public MyEntity222MultivalueService() {
		super(MyEntity222MultivalueDTO.class, MyEntity222.class, null, MyEntity222MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity222MultivalueDTO> doCreateEntity(MyEntity222 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity222MultivalueDTO> doUpdateEntity(MyEntity222 entity, MyEntity222MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}