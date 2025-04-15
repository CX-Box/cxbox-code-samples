package org.demo.documentation.widgets.additionalinfo.colortitle.forfields;

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
public class MyEntity3030PickService extends VersionAwareResponseService<MyEntity3030PickDTO, MyEntity3030> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3030PickMeta> meta = MyEntity3030PickMeta.class;

    @Override
    protected CreateResult<MyEntity3030PickDTO> doCreateEntity(MyEntity3030 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3030PickDTO> doUpdateEntity(MyEntity3030 entity, MyEntity3030PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}