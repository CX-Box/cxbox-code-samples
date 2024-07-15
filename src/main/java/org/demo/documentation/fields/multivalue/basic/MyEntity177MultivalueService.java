package org.demo.documentation.fields.multivalue.basic;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Getter
@Service
public class MyEntity177MultivalueService extends VersionAwareResponseService<MyEntity177MultivalueDTO, MyEntityMultivalue177> {

	public MyEntity177MultivalueService() {
		super(MyEntity177MultivalueDTO.class, MyEntityMultivalue177.class, null, MyEntity177MultivalueMeta.class);
	}

	@Override
	protected CreateResult<MyEntity177MultivalueDTO> doCreateEntity(MyEntityMultivalue177 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity177MultivalueDTO> doUpdateEntity(MyEntityMultivalue177 entity, MyEntity177MultivalueDTO data,
                                                                       BusinessComponent bc) {
		return null;
	}


}