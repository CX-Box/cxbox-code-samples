package org.demo.documentation.fields.multivalue.required;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity189MultivalueService extends VersionAwareResponseService<MyEntity189MultivalueDTO, MyEntity189> {

	public MyEntity189MultivalueService() {
		super(MyEntity189MultivalueDTO.class, MyEntity189.class, null, MyEntity189MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity189MultivalueDTO> doCreateEntity(MyEntity189 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity189MultivalueDTO> doUpdateEntity(MyEntity189 entity, MyEntity189MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}