package org.demo.documentation.fields.multivalue.sorting;

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
public class MyEntity191MultivalueService extends VersionAwareResponseService<MyEntity191MultivalueDTO, MyEntity191> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity191MultivalueMeta> meta = MyEntity191MultivalueMeta.class;

    @Override
	protected CreateResult<MyEntity191MultivalueDTO> doCreateEntity(MyEntity191 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity191MultivalueDTO> doUpdateEntity(MyEntity191 entity, MyEntity191MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}