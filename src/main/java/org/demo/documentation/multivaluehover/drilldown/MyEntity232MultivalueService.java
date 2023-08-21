package org.demo.documentation.multivaluehover.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity232MultivalueService extends VersionAwareResponseService<MyEntity232MultivalueDTO, MyEntity232> {

	public MyEntity232MultivalueService() {
		super(MyEntity232MultivalueDTO.class, MyEntity232.class, null, MyEntity232MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity232MultivalueDTO> doCreateEntity(MyEntity232 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity232MultivalueDTO> doUpdateEntity(MyEntity232 entity, MyEntity232MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}