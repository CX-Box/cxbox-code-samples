package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

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
public class MyEntity4902PickPickService extends VersionAwareResponseService<MyEntity4902PickPickDTO, MyEntity4902Pick> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity4902PickPickMeta> meta = MyEntity4902PickPickMeta.class;

    @Override
    protected CreateResult<MyEntity4902PickPickDTO> doCreateEntity(MyEntity4902Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4902PickPickDTO> doUpdateEntity(MyEntity4902Pick entity, MyEntity4902PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}