package org.demo.documentation.fields.multivaluetree.primary;

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
public class MyEntity3320MultivalueService extends VersionAwareResponseService<MyEntity3320MultivalueDTO, MyEntity3320Multivalue> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3320MultivalueMeta> meta = MyEntity3320MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity3320MultivalueDTO> doCreateEntity(MyEntity3320Multivalue entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3320MultivalueDTO> doUpdateEntity(MyEntity3320Multivalue entity, MyEntity3320MultivalueDTO data,
																		BusinessComponent bc) {
		return null;
	}


}