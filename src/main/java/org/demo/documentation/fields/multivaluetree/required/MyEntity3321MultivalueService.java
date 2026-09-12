package org.demo.documentation.fields.multivaluetree.required;

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
public class MyEntity3321MultivalueService extends VersionAwareResponseService<MyEntity3321MultivalueDTO, MyEntity3321Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3321MultivalueMeta> meta = MyEntity3321MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3321MultivalueDTO> doCreateEntity(MyEntity3321Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3321MultivalueDTO> doUpdateEntity(MyEntity3321Multivalue entity, MyEntity3321MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}