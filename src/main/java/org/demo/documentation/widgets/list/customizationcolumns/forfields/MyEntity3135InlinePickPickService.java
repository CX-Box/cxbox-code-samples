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
public class MyEntity3135InlinePickPickService extends VersionAwareResponseService<MyEntity3135InlinePickPickDTO, MyEntity3135InlinePick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3135InlinePickPickMeta> meta = MyEntity3135InlinePickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3135InlinePickPickDTO> doCreateEntity(MyEntity3135InlinePick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3135InlinePickPickDTO> doUpdateEntity(MyEntity3135InlinePick entity, MyEntity3135InlinePickPickDTO data,
                                                                            BusinessComponent bc) {
        return null;
    }


}