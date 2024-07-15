package org.demo.documentation.fields.multivalue.colorconst;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity179MultivalueService extends VersionAwareResponseService<MyEntity179MultivalueDTO, MyEntity179> {

	public MyEntity179MultivalueService() {
		super(MyEntity179MultivalueDTO.class, MyEntity179.class, null, MyEntity179MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity179MultivalueDTO> doCreateEntity(MyEntity179 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity179MultivalueDTO> doUpdateEntity(MyEntity179 entity, MyEntity179MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}