package org.demo.documentation.feature.customizationcolumns.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3135PickPickService extends VersionAwareResponseService<MyEntity3135PickPickDTO, MyEntity3135Pick> {

    public MyEntity3135PickPickService() {
        super(MyEntity3135PickPickDTO.class, MyEntity3135Pick.class, null, MyEntity3135PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3135PickPickDTO> doCreateEntity(MyEntity3135Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3135PickPickDTO> doUpdateEntity(MyEntity3135Pick entity, MyEntity3135PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}