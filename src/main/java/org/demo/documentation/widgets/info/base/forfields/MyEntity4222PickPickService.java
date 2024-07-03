package org.demo.documentation.widgets.info.base.forfields;

import lombok.Getter;

import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4222PickPickService extends VersionAwareResponseService<MyEntity4222PickPickDTO, MyEntity4222Pick> {

    public MyEntity4222PickPickService() {
        super(MyEntity4222PickPickDTO.class, MyEntity4222Pick.class, null, MyEntity4222PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4222PickPickDTO> doCreateEntity(MyEntity4222Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4222PickPickDTO> doUpdateEntity(MyEntity4222Pick entity, MyEntity4222PickPickDTO data,
                                                                     BusinessComponent bc) {
        return null;
    }


}