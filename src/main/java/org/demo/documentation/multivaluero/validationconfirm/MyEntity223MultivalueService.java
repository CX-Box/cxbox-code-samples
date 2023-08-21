package org.demo.documentation.multivaluero.validationconfirm;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity223MultivalueService extends VersionAwareResponseService<MyEntity223MultivalueDTO, MyEntity223> {

	public MyEntity223MultivalueService() {
		super(MyEntity223MultivalueDTO.class, MyEntity223.class, null, MyEntity223MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity223MultivalueDTO> doCreateEntity(MyEntity223 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity223MultivalueDTO> doUpdateEntity(MyEntity223 entity, MyEntity223MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}