package org.demo.documentation.widgets.additionalinfo.base.forfields;

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
public class MyEntity3600PickPickService extends VersionAwareResponseService<MyEntity3600PickPickDTO, MyEntity3600Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3600PickPickMeta> meta = MyEntity3600PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3600PickPickDTO> doCreateEntity(MyEntity3600Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3600PickPickDTO> doUpdateEntity(MyEntity3600Pick entity, MyEntity3600PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}