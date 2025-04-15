package org.demo.documentation.fields.multivalue.validationdynamic;


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
public class MyEntity337MultivalueService extends VersionAwareResponseService<MyEntity337MultivalueDTO, MyEntity337> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity337MultivalueMeta> meta = MyEntity337MultivalueMeta.class;

    @Override
	protected CreateResult<MyEntity337MultivalueDTO> doCreateEntity(MyEntity337 entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity337MultivalueDTO> doUpdateEntity(MyEntity337 entity, MyEntity337MultivalueDTO data,
			BusinessComponent bc) {
		return null;
	}


}