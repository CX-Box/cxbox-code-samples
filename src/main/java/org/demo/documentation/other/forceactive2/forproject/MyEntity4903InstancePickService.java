package org.demo.documentation.other.forceactive2.forproject;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4903InstancePickService extends VersionAwareResponseService<MyEntity4903InstancePickDTO, MyEntity4903Instance> {

    public MyEntity4903InstancePickService() {
        super(MyEntity4903InstancePickDTO.class, MyEntity4903Instance.class, null, MyEntity4903InstancePickMeta.class);
    }

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