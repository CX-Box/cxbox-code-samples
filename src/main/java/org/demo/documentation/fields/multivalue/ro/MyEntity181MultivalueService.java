package org.demo.documentation.fields.multivalue.ro;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity181MultivalueService extends VersionAwareResponseService<MyEntity181MultivalueDTO, MyEntity181> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity181MultivalueMeta> meta = MyEntity181MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity181MultivalueDTO> doCreateEntity(MyEntity181 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity181MultivalueDTO> doUpdateEntity(MyEntity181 entity, MyEntity181MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}