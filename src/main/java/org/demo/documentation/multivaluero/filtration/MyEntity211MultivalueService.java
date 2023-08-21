package org.demo.documentation.multivaluero.filtration;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity211MultivalueService extends VersionAwareResponseService<MyEntity211MultivalueDTO, MyEntity211> {

	public MyEntity211MultivalueService() {
		super(MyEntity211MultivalueDTO.class, MyEntity211.class, null, MyEntity211MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity211MultivalueDTO> doCreateEntity(MyEntity211 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity211MultivalueDTO> doUpdateEntity(MyEntity211 entity, MyEntity211MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}