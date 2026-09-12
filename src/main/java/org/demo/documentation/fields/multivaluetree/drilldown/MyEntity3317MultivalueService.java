package org.demo.documentation.fields.multivaluetree.drilldown;

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
public class MyEntity3317MultivalueService extends VersionAwareResponseService<MyEntity3317MultivalueDTO, MyEntity3317Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3317MultivalueMeta> meta = MyEntity3317MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3317MultivalueDTO> doCreateEntity(MyEntity3317Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3317MultivalueDTO> doUpdateEntity(MyEntity3317Multivalue entity, MyEntity3317MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}