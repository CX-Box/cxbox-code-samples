package org.demo.documentation.fields.multivalue.required;

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
public class MyEntity189MultivalueService extends VersionAwareResponseService<MyEntity189MultivalueDTO, MyEntity189> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity189MultivalueMeta> meta = MyEntity189MultivalueMeta.class;

    @Override
	protected CreateResult<MyEntity189MultivalueDTO> doCreateEntity(MyEntity189 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity189MultivalueDTO> doUpdateEntity(MyEntity189 entity, MyEntity189MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}