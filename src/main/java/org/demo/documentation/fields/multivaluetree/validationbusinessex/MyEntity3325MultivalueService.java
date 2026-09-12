package org.demo.documentation.fields.multivaluetree.validationbusinessex;

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
public class MyEntity3325MultivalueService extends VersionAwareResponseService<MyEntity3325MultivalueDTO, MyEntity3325Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3325MultivalueMeta> meta = MyEntity3325MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3325MultivalueDTO> doCreateEntity(MyEntity3325Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3325MultivalueDTO> doUpdateEntity(MyEntity3325Multivalue entity, MyEntity3325MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}