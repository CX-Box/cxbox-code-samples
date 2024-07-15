package org.demo.documentation.fields.multivalue.color;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity175MultivalueService extends VersionAwareResponseService<MyEntity175MultivalueDTO, MyEntity175> {

	public MyEntity175MultivalueService() {
		super(MyEntity175MultivalueDTO.class, MyEntity175.class, null, MyEntity175MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity175MultivalueDTO> doCreateEntity(MyEntity175 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity175MultivalueDTO> doUpdateEntity(MyEntity175 entity, MyEntity175MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}