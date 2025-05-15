package org.demo.documentation.fields.multivaluehover.placeholder;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntityMulti235PickService extends VersionAwareResponseService<MyEntityMulti235PickDTO, MyEntityMulti235> {

    public MyEntityMulti235PickService() {
        super(MyEntityMulti235PickDTO.class, MyEntityMulti235.class, null, MyEntityMulti235PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntityMulti235PickDTO> doCreateEntity(MyEntityMulti235 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntityMulti235PickDTO> doUpdateEntity(MyEntityMulti235 entity, MyEntityMulti235PickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}