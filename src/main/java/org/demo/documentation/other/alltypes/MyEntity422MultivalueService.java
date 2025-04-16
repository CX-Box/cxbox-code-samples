package org.demo.documentation.other.alltypes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity422MultivalueService extends VersionAwareResponseService<MyEntity422MultivalueDTO, MyEntity422> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity422MultivalueMeta> meta = MyEntity422MultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity422MultivalueDTO> doCreateEntity(MyEntity422 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity422MultivalueDTO> doUpdateEntity(MyEntity422 entity, MyEntity422MultivalueDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}