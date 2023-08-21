package org.demo.documentation.multivalue.validationconfirm;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity195MultivalueService extends VersionAwareResponseService<MyEntity195MultivalueDTO, MyEntity195> {

	public MyEntity195MultivalueService() {
		super(MyEntity195MultivalueDTO.class, MyEntity195.class, null, MyEntity195MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity195MultivalueDTO> doCreateEntity(MyEntity195 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity195MultivalueDTO> doUpdateEntity(MyEntity195 entity, MyEntity195MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}