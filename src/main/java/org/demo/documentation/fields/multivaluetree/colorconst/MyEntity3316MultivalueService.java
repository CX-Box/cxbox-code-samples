package org.demo.documentation.fields.multivaluetree.colorconst;

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
public class MyEntity3316MultivalueService extends VersionAwareResponseService<MyEntity3316MultivalueDTO, MyEntity3316Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3316MultivalueMeta> meta = MyEntity3316MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3316MultivalueDTO> doCreateEntity(MyEntity3316Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3316MultivalueDTO> doUpdateEntity(MyEntity3316Multivalue entity, MyEntity3316MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}