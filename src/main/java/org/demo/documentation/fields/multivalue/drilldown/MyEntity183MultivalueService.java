package org.demo.documentation.fields.multivalue.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity183MultivalueService extends VersionAwareResponseService<MyEntity183MultivalueDTO, MyEntity183> {

	public MyEntity183MultivalueService() {
		super(MyEntity183MultivalueDTO.class, MyEntity183.class, null, MyEntity183MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity183MultivalueDTO> doCreateEntity(MyEntity183 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity183MultivalueDTO> doUpdateEntity(MyEntity183 entity, MyEntity183MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}