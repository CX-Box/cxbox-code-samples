package org.demo.documentation.multivaluero.drilldown;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity209MultivalueService extends VersionAwareResponseService<MyEntity209MultivalueDTO, MyEntity209> {

	public MyEntity209MultivalueService() {
		super(MyEntity209MultivalueDTO.class, MyEntity209.class, null, MyEntity209MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity209MultivalueDTO> doCreateEntity(MyEntity209 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity209MultivalueDTO> doUpdateEntity(MyEntity209 entity, MyEntity209MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}