package org.demo.documentation.multivaluero.placeholder;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity213MultivalueService extends VersionAwareResponseService<MyEntity213MultivalueDTO, MyEntity213> {

	public MyEntity213MultivalueService() {
		super(MyEntity213MultivalueDTO.class, MyEntity213.class, null, MyEntity213MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity213MultivalueDTO> doCreateEntity(MyEntity213 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity213MultivalueDTO> doUpdateEntity(MyEntity213 entity, MyEntity213MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}