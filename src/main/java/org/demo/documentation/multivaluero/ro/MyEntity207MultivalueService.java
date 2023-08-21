package org.demo.documentation.multivaluero.ro;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity207MultivalueService extends VersionAwareResponseService<MyEntity207MultivalueDTO, MyEntity207> {

	public MyEntity207MultivalueService() {
		super(MyEntity207MultivalueDTO.class, MyEntity207.class, null, MyEntity207MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity207MultivalueDTO> doCreateEntity(MyEntity207 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity207MultivalueDTO> doUpdateEntity(MyEntity207 entity, MyEntity207MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}