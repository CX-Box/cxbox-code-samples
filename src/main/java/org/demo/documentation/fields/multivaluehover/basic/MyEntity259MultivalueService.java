package org.demo.documentation.fields.multivaluehover.basic;

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
public class MyEntity259MultivalueService extends VersionAwareResponseService<MyEntity259MultivalueDTO, MyEntity259> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity259MultivalueMeta> meta = MyEntity259MultivalueMeta.class;

	@Override
	protected CreateResult<MyEntity259MultivalueDTO> doCreateEntity(MyEntity259 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity259MultivalueDTO> doUpdateEntity(MyEntity259 entity, MyEntity259MultivalueDTO data,
																	   BusinessComponent bc) {
		return null;
	}


}