package org.demo.documentation.widgets.form.base.allfields.forfields;

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
public class MyEntity3010PickPickService extends VersionAwareResponseService<MyEntity3010PickPickDTO, MyEntity3010Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3010PickPickMeta> meta = MyEntity3010PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3010PickPickDTO> doCreateEntity(MyEntity3010Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3010PickPickDTO> doUpdateEntity(MyEntity3010Pick entity, MyEntity3010PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}