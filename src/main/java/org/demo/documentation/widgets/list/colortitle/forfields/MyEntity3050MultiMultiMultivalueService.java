package org.demo.documentation.widgets.list.colortitle.forfields;

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
public class MyEntity3050MultiMultiMultivalueService extends VersionAwareResponseService<MyEntity3050MultiMultiMultivalueDTO, org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMulti> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3050MultiMultiMultivalueMeta> meta = MyEntity3050MultiMultiMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3050MultiMultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMulti entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3050MultiMultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050MultiMulti entity, MyEntity3050MultiMultiMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}