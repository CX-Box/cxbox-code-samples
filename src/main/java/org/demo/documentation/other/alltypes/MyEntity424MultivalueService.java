package org.demo.documentation.other.alltypes;

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
public class MyEntity424MultivalueService extends VersionAwareResponseService<MyEntity424MultivalueDTO, MyEntity424> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity424MultivalueMeta> meta = MyEntity424MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity424MultivalueDTO> doCreateEntity(MyEntity424 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity424MultivalueDTO> doUpdateEntity(MyEntity424 entity, MyEntity424MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}