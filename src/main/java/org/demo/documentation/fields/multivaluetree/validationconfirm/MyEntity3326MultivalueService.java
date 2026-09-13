package org.demo.documentation.fields.multivaluetree.validationconfirm;

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
public class MyEntity3326MultivalueService extends VersionAwareResponseService<MyEntity3326MultivalueDTO, MyEntity3326Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3326MultivalueMeta> meta = MyEntity3326MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3326MultivalueDTO> doCreateEntity(MyEntity3326Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3326MultivalueDTO> doUpdateEntity(MyEntity3326Multivalue entity, MyEntity3326MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}