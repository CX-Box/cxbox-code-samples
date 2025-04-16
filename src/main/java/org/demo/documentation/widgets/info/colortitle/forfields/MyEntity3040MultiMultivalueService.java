package org.demo.documentation.widgets.info.colortitle.forfields;

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
public class MyEntity3040MultiMultivalueService extends VersionAwareResponseService<MyEntity3040MultiMultivalueDTO, org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3040MultiMultivalueMeta> meta = MyEntity3040MultiMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3040MultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3040MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.info.colortitle.forfields.MyEntity3040Multi entity, MyEntity3040MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}