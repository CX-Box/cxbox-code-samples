package org.demo.documentation.multivaluero.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity203MultivalueService extends VersionAwareResponseService<MyEntity203MultivalueDTO, MyEntity203> {

	public MyEntity203MultivalueService() {
		super(MyEntity203MultivalueDTO.class, MyEntity203.class, null, MyEntity203MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity203MultivalueDTO> doCreateEntity(MyEntity203 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity203MultivalueDTO> doUpdateEntity(MyEntity203 entity, MyEntity203MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}