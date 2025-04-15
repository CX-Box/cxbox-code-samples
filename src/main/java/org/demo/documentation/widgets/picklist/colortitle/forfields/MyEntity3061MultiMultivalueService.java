package org.demo.documentation.widgets.picklist.colortitle.forfields;

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
public class MyEntity3061MultiMultivalueService extends VersionAwareResponseService<MyEntity3061MultiMultivalueDTO, org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3061MultiMultivalueMeta> meta = MyEntity3061MultiMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3061MultiMultivalueDTO> doCreateEntity(org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3061MultiMultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061Multi entity, MyEntity3061MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}