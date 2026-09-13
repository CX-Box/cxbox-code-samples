package org.demo.documentation.fields.multivaluetree.validationruntimeex;

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
public class MyEntity3328MultivalueService extends VersionAwareResponseService<MyEntity3328MultivalueDTO, MyEntity3328Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3328MultivalueMeta> meta = MyEntity3328MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3328MultivalueDTO> doCreateEntity(MyEntity3328Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3328MultivalueDTO> doUpdateEntity(MyEntity3328Multivalue entity, MyEntity3328MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}