package org.demo.documentation.fields.multivalue.validationconfirm;

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
public class MyEntity195MultivalueService extends VersionAwareResponseService<MyEntity195MultivalueDTO, MyEntity195> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity195MultivalueMeta> meta = MyEntity195MultivalueMeta.class;

    @Override
	protected CreateResult<MyEntity195MultivalueDTO> doCreateEntity(MyEntity195 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity195MultivalueDTO> doUpdateEntity(MyEntity195 entity, MyEntity195MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}