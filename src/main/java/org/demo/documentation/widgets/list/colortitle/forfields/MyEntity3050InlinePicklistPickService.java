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
public class MyEntity3050InlinePicklistPickService extends VersionAwareResponseService<MyEntity3050InlinePicklistPickDTO, MyEntity3050InlinePicklist> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3050InlinePicklistPickMeta> meta = MyEntity3050InlinePicklistPickMeta.class;

    @Override
    protected CreateResult<MyEntity3050InlinePicklistPickDTO> doCreateEntity(MyEntity3050InlinePicklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3050InlinePicklistPickDTO> doUpdateEntity(MyEntity3050InlinePicklist entity, MyEntity3050InlinePicklistPickDTO data,
                                                                                BusinessComponent bc) {
        return null;
    }


}