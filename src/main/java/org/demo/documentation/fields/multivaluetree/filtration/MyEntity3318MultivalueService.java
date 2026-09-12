package org.demo.documentation.fields.multivaluetree.filtration;

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
public class MyEntity3318MultivalueService extends VersionAwareResponseService<MyEntity3318MultivalueDTO, MyEntity3318Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3318MultivalueMeta> meta = MyEntity3318MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3318MultivalueDTO> doCreateEntity(MyEntity3318Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3318MultivalueDTO> doUpdateEntity(MyEntity3318Multivalue entity, MyEntity3318MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}