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
public class MyEntity4903InstancePickService extends VersionAwareResponseService<MyEntity4903InstancePickDTO, MyEntity4903Instance> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity4903InstancePickMeta> meta = MyEntity4903InstancePickMeta.class;

    @Override
    protected CreateResult<MyEntity4903InstancePickDTO> doCreateEntity(MyEntity4903Instance entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4903InstancePickDTO> doUpdateEntity(MyEntity4903Instance entity, MyEntity4903InstancePickDTO data,
                                                                          BusinessComponent bc) {
        return null;
    }


}