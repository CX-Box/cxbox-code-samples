package org.demo.documentation.fields.multivalue.colorconst;

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
public class MyEntity179MultivalueService extends VersionAwareResponseService<MyEntity179MultivalueDTO, MyEntity179> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity179MultivalueMeta> meta = MyEntity179MultivalueMeta.class;

    @Override
	protected CreateResult<MyEntity179MultivalueDTO> doCreateEntity(MyEntity179 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity179MultivalueDTO> doUpdateEntity(MyEntity179 entity, MyEntity179MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}