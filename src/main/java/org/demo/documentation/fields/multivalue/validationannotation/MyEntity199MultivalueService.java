package org.demo.documentation.fields.multivalue.validationannotation;

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
public class MyEntity199MultivalueService extends VersionAwareResponseService<MyEntity199MultivalueDTO, MyEntity199> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity199MultivalueMeta> meta = MyEntity199MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity199MultivalueDTO> doCreateEntity(MyEntity199 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity199MultivalueDTO> doUpdateEntity(MyEntity199 entity, MyEntity199MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}