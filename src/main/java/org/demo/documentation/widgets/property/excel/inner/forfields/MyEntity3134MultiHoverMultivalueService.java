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
public class MyEntity3134MultiHoverMultivalueService extends VersionAwareResponseService<MyEntity3134MultiHoverMultivalueDTO, MyEntity3134MultiHover> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3134MultiHoverMultivalueMeta> meta = MyEntity3134MultiHoverMultivalueMeta.class;

    @Override
    protected CreateResult<MyEntity3134MultiHoverMultivalueDTO> doCreateEntity(MyEntity3134MultiHover entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3134MultiHoverMultivalueDTO> doUpdateEntity(MyEntity3134MultiHover entity, MyEntity3134MultiHoverMultivalueDTO data,
                                                                                  BusinessComponent bc) {
        return null;
    }


}