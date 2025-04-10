package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

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
public class MyEntity3035MultivalueService extends VersionAwareResponseService<MyEntity3035MultivalueDTO, org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3035MultivalueMeta> meta = MyEntity3035MultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3035MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3035MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035 entity, MyEntity3035MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}