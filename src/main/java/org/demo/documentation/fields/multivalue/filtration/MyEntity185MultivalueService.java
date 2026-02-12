package org.demo.documentation.fields.multivalue.filtration;

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
public class MyEntity185MultivalueService extends VersionAwareResponseService<MyEntity185MultivalueDTO, MyEntity185> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity185MultivalueMeta> meta = MyEntity185MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity185MultivalueDTO> doCreateEntity(MyEntity185 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity185MultivalueDTO> doUpdateEntity(MyEntity185 entity, MyEntity185MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}