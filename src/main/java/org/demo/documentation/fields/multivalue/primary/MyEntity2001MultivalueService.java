package org.demo.documentation.fields.multivalue.primary;

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
public class MyEntity2001MultivalueService extends VersionAwareResponseService<MyEntity2001MultivalueDTO, MyEntity2001> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity2001MultivalueMeta> meta = MyEntity2001MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity2001MultivalueDTO> doCreateEntity(MyEntity2001 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity2001MultivalueDTO> doUpdateEntity(MyEntity2001 entity, MyEntity2001MultivalueDTO data,
																		BusinessComponent bc) {
		return null;
	}


}