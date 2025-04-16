package org.demo.documentation.widgets.picklist.base.allfields.forfields;

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
public class MyEntity3067MultiMultivalueService extends VersionAwareResponseService<MyEntity3067MultiMultivalueDTO, MyEntity3067Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3067MultiMultivalueMeta> meta = MyEntity3067MultiMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3067MultiMultivalueDTO> doCreateEntity(MyEntity3067Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3067MultiMultivalueDTO> doUpdateEntity(MyEntity3067Multi entity, MyEntity3067MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}