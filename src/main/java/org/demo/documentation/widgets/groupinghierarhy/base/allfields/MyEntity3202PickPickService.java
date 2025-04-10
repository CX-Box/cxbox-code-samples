package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

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
public class MyEntity3202PickPickService extends VersionAwareResponseService<MyEntity3202PickPickDTO, MyEntity3202Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3202PickPickMeta> meta = MyEntity3202PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3202PickPickDTO> doCreateEntity(MyEntity3202Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3202PickPickDTO> doUpdateEntity(MyEntity3202Pick entity, MyEntity3202PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}