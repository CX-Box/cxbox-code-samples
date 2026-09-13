package org.demo.documentation.fields.multivaluetree.sorting;

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
public class MyEntity3323MultivalueService extends VersionAwareResponseService<MyEntity3323MultivalueDTO, MyEntity3323Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3323MultivalueMeta> meta = MyEntity3323MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3323MultivalueDTO> doCreateEntity(MyEntity3323Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3323MultivalueDTO> doUpdateEntity(MyEntity3323Multivalue entity, MyEntity3323MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}