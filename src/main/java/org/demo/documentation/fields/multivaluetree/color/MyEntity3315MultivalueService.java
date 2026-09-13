package org.demo.documentation.fields.multivaluetree.color;

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
public class MyEntity3315MultivalueService extends VersionAwareResponseService<MyEntity3315MultivalueDTO, MyEntity3315Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3315MultivalueMeta> meta = MyEntity3315MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3315MultivalueDTO> doCreateEntity(MyEntity3315Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3315MultivalueDTO> doUpdateEntity(MyEntity3315Multivalue entity, MyEntity3315MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}