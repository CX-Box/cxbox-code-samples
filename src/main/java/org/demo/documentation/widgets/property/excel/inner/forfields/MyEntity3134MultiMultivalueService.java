package org.demo.documentation.widgets.property.excel.inner.forfields;

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
public class MyEntity3134MultiMultivalueService extends VersionAwareResponseService<MyEntity3134MultiMultivalueDTO, MyEntity3134Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3134MultiMultivalueMeta> meta = MyEntity3134MultiMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3134MultiMultivalueDTO> doCreateEntity(MyEntity3134Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3134MultiMultivalueDTO> doUpdateEntity(MyEntity3134Multi entity, MyEntity3134MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}