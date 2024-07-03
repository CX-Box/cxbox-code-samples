package org.demo.documentation.widgets.info.base.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4222Pick2PickService extends VersionAwareResponseService<MyEntity4222Pick2PickDTO, MyEntity4222Pick2> {

    public MyEntity4222Pick2PickService() {
        super(MyEntity4222Pick2PickDTO.class, MyEntity4222Pick2.class, null, MyEntity4222Pick2PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4222Pick2PickDTO> doCreateEntity(MyEntity4222Pick2 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4222Pick2PickDTO> doUpdateEntity(MyEntity4222Pick2 entity, MyEntity4222Pick2PickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}