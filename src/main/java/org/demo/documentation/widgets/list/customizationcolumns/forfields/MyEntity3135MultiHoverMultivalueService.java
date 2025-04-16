package org.demo.documentation.widgets.list.customizationcolumns.forfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3135MultiHoverMultivalueService extends VersionAwareResponseService<MyEntity3135MultiHoverMultivalueDTO, MyEntity3135MultiHover> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3135MultiHoverMultivalueMeta> meta = MyEntity3135MultiHoverMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3135MultiHoverMultivalueDTO> doCreateEntity(MyEntity3135MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3135MultiHoverMultivalueDTO> doUpdateEntity(MyEntity3135MultiHover entity, MyEntity3135MultiHoverMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}