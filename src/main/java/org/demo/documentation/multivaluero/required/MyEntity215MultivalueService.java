package org.demo.documentation.multivaluero.required;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity215MultivalueService extends VersionAwareResponseService<MyEntity215MultivalueDTO, MyEntity215> {

	public MyEntity215MultivalueService() {
		super(MyEntity215MultivalueDTO.class, MyEntity215.class, null, MyEntity215MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity215MultivalueDTO> doCreateEntity(MyEntity215 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity215MultivalueDTO> doUpdateEntity(MyEntity215 entity, MyEntity215MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}