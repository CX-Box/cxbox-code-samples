package org.demo.documentation.fields.multivalue.filtration;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity185MultivalueService extends VersionAwareResponseService<MyEntity185MultivalueDTO, MyEntity185> {

	public MyEntity185MultivalueService() {
		super(MyEntity185MultivalueDTO.class, MyEntity185.class, null, MyEntity185MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity185MultivalueDTO> doCreateEntity(MyEntity185 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity185MultivalueDTO> doUpdateEntity(MyEntity185 entity, MyEntity185MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}