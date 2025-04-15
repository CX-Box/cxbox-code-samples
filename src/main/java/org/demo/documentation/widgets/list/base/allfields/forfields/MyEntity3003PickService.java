package org.demo.documentation.widgets.list.base.allfields.forfields;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.demo.documentation.widgets.form.title.MyEntity3003;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3003PickService extends VersionAwareResponseService<MyEntity3003PickDTO, MyEntity3003> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3003PickMeta> meta = MyEntity3003PickMeta.class;

    @Override
    protected CreateResult<MyEntity3003PickDTO> doCreateEntity(MyEntity3003 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3003PickDTO> doUpdateEntity(MyEntity3003 entity, MyEntity3003PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}