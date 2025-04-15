package org.demo.documentation.widgets.formpopup.colortitle.forfields;

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
public class MyEntity3042MultivalueService extends VersionAwareResponseService<MyEntity3042MultivalueDTO, org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3042MultivalueMeta> meta = MyEntity3042MultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3042MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3042MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.formpopup.colortitle.forfields.MyEntity3042 entity, MyEntity3042MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}