package org.demo.documentation.multivalue.sorting;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity191MultivalueService extends VersionAwareResponseService<MyEntity191MultivalueDTO, MyEntity191> {

	public MyEntity191MultivalueService() {
		super(MyEntity191MultivalueDTO.class, MyEntity191.class, null, MyEntity191MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity191MultivalueDTO> doCreateEntity(MyEntity191 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity191MultivalueDTO> doUpdateEntity(MyEntity191 entity, MyEntity191MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}