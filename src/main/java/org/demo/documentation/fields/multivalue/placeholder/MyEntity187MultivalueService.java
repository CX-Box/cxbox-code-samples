package org.demo.documentation.fields.multivalue.placeholder;

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
public class MyEntity187MultivalueService extends VersionAwareResponseService<MyEntity187MultivalueDTO, MyEntity187> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity187MultivalueMeta> meta = MyEntity187MultivalueMeta.class;

    @Override
	protected CreateResult<MyEntity187MultivalueDTO> doCreateEntity(MyEntity187 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity187MultivalueDTO> doUpdateEntity(MyEntity187 entity, MyEntity187MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}