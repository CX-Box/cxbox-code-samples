package org.demo.documentation.widgets.form.colortitle.forfields;

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
public class MyEntity3037MultivalueService extends VersionAwareResponseService<MyEntity3037MultivalueDTO, org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3037> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3037MultivalueMeta> meta = MyEntity3037MultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3037MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3037 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3037MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3037 entity, MyEntity3037MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}