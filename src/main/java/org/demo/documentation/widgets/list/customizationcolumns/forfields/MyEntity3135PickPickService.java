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
public class MyEntity3135PickPickService extends VersionAwareResponseService<MyEntity3135PickPickDTO, MyEntity3135Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3135PickPickMeta> meta = MyEntity3135PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3135PickPickDTO> doCreateEntity(MyEntity3135Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3135PickPickDTO> doUpdateEntity(MyEntity3135Pick entity, MyEntity3135PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}