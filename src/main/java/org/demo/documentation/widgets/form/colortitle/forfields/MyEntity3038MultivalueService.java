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
public class MyEntity3038MultivalueService extends VersionAwareResponseService<MyEntity3038MultivalueDTO, org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3038MultivalueMeta> meta = MyEntity3038MultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3038MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3038MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.form.colortitle.forfields.MyEntity3038 entity, MyEntity3038MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}