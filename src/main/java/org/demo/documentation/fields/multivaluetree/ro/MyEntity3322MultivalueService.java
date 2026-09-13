package org.demo.documentation.fields.multivaluetree.ro;

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
public class MyEntity3322MultivalueService extends VersionAwareResponseService<MyEntity3322MultivalueDTO, MyEntity3322Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3322MultivalueMeta> meta = MyEntity3322MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3322MultivalueDTO> doCreateEntity(MyEntity3322Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3322MultivalueDTO> doUpdateEntity(MyEntity3322Multivalue entity, MyEntity3322MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}