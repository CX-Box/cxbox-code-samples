package org.demo.documentation.fields.multivaluetree.placeholder;

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
public class MyEntity3319MultivalueService extends VersionAwareResponseService<MyEntity3319MultivalueDTO, MyEntity3319Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3319MultivalueMeta> meta = MyEntity3319MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3319MultivalueDTO> doCreateEntity(MyEntity3319Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3319MultivalueDTO> doUpdateEntity(MyEntity3319Multivalue entity, MyEntity3319MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}