package org.demo.documentation.fields.multivaluehover.validationdynamic;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity339PickService extends VersionAwareResponseService<MyEntity339PickDTO, MyEntity339> {

    public MyEntity339PickService() {
        super(MyEntity339PickDTO.class, MyEntity339.class, null, MyEntity339PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity339PickDTO> doCreateEntity(MyEntity339 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity339PickDTO> doUpdateEntity(MyEntity339 entity, MyEntity339PickDTO data,
                                                                 BusinessComponent bc) {
        return null;
    }


}