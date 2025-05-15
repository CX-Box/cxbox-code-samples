package org.demo.documentation.fields.multivaluehover.validationruntimeex;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity246PickService extends VersionAwareResponseService<MyEntity246PickDTO, MyEntity246> {

    public MyEntity246PickService() {
        super(MyEntity246PickDTO.class, MyEntity246.class, null, MyEntity246PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity246PickDTO> doCreateEntity(MyEntity246 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity246PickDTO> doUpdateEntity(MyEntity246 entity, MyEntity246PickDTO data,
                                                                 BusinessComponent bc) {
        return null;
    }


}