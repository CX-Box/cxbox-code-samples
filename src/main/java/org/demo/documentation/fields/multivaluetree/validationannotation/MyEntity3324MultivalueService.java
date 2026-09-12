package org.demo.documentation.fields.multivaluetree.validationannotation;

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
public class MyEntity3324MultivalueService extends VersionAwareResponseService<MyEntity3324MultivalueDTO, MyEntity3324Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3324MultivalueMeta> meta = MyEntity3324MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3324MultivalueDTO> doCreateEntity(MyEntity3324Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3324MultivalueDTO> doUpdateEntity(MyEntity3324Multivalue entity, MyEntity3324MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}