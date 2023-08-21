package org.demo.documentation.multivaluero.colorconst;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity205MultivalueService extends VersionAwareResponseService<MyEntity205MultivalueDTO, MyEntity205> {

	public MyEntity205MultivalueService() {
		super(MyEntity205MultivalueDTO.class, MyEntity205.class, null, MyEntity205MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity205MultivalueDTO> doCreateEntity(MyEntity205 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity205MultivalueDTO> doUpdateEntity(MyEntity205 entity, MyEntity205MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}