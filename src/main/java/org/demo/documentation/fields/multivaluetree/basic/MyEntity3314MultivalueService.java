package org.demo.documentation.fields.multivaluetree.basic;

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
public class MyEntity3314MultivalueService extends VersionAwareResponseService<MyEntity3314MultivalueDTO, MyEntity3314Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3314MultivalueMeta> meta = MyEntity3314MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3314MultivalueDTO> doCreateEntity(MyEntity3314Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3314MultivalueDTO> doUpdateEntity(MyEntity3314Multivalue entity, MyEntity3314MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}