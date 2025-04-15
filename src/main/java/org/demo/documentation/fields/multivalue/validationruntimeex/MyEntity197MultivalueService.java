package org.demo.documentation.fields.multivalue.validationruntimeex;

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
public class MyEntity197MultivalueService extends VersionAwareResponseService<MyEntity197MultivalueDTO, MyEntity197> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity197MultivalueMeta> meta = MyEntity197MultivalueMeta.class;

    @Override
	protected CreateResult<MyEntity197MultivalueDTO> doCreateEntity(MyEntity197 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity197MultivalueDTO> doUpdateEntity(MyEntity197 entity, MyEntity197MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}