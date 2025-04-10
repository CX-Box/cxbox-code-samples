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
public class MyEntity3050MultiMultivalueService extends VersionAwareResponseService<MyEntity3050MultiMultivalueDTO, org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3050MultiMultivalueMeta> meta = MyEntity3050MultiMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3050MultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3050MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.list.colortitle.forfields.MyEntity3050Multi entity, MyEntity3050MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}