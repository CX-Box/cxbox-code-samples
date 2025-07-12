package org.demo.documentation.other.forceactive2.forproject;

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
public class MyEntity4903FileNamePickPickService extends VersionAwareResponseService<MyEntity4903FileNamePickPickDTO, MyEntity4903FileNamePick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity4903FileNamePickPickMeta> meta = MyEntity4903FileNamePickPickMeta.class;

    @Override
    protected CreateResult<MyEntity4903FileNamePickPickDTO> doCreateEntity(MyEntity4903FileNamePick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4903FileNamePickPickDTO> doUpdateEntity(MyEntity4903FileNamePick entity, MyEntity4903FileNamePickPickDTO data,
                                                                              BusinessComponent bc) {
        return null;
    }


}