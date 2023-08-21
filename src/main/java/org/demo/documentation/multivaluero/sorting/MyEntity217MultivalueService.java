package org.demo.documentation.multivaluero.sorting;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity217MultivalueService extends VersionAwareResponseService<MyEntity217MultivalueDTO, MyEntity217> {

	public MyEntity217MultivalueService() {
		super(MyEntity217MultivalueDTO.class, MyEntity217.class, null, MyEntity217MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity217MultivalueDTO> doCreateEntity(MyEntity217 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity217MultivalueDTO> doUpdateEntity(MyEntity217 entity, MyEntity217MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}