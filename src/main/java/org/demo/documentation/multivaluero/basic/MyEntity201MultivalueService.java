package org.demo.documentation.multivaluero.basic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity201MultivalueService extends VersionAwareResponseService<MyEntity201MultivalueDTO, MyEntity201> {

	public MyEntity201MultivalueService() {
		super(MyEntity201MultivalueDTO.class, MyEntity201.class, null, MyEntity201MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity201MultivalueDTO> doCreateEntity(MyEntity201 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity201MultivalueDTO> doUpdateEntity(MyEntity201 entity, MyEntity201MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}