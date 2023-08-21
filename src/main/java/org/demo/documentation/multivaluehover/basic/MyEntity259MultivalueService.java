package org.demo.documentation.multivaluehover.basic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity259MultivalueService extends VersionAwareResponseService<MyEntity259MultivalueDTO, MyEntity259> {

	public MyEntity259MultivalueService() {
		super(MyEntity259MultivalueDTO.class, MyEntity259.class, null, MyEntity259MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity259MultivalueDTO> doCreateEntity(MyEntity259 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity259MultivalueDTO> doUpdateEntity(MyEntity259 entity, MyEntity259MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}