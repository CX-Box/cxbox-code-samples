package org.demo.documentation.widgets.picklist.colortitle.forfields;

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
public class MyEntity3061PickPickPickService extends VersionAwareResponseService<MyEntity3061PickPickPickDTO, MyEntity3061PickPick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3061PickPickPickMeta> meta = MyEntity3061PickPickPickMeta.class;

    @Override
    protected CreateResult<MyEntity3061PickPickPickDTO> doCreateEntity(MyEntity3061PickPick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3061PickPickPickDTO> doUpdateEntity(MyEntity3061PickPick entity, MyEntity3061PickPickPickDTO data,
                                                                          BusinessComponent bc) {
        return null;
    }


}