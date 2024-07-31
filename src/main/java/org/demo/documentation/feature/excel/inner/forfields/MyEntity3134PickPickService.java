package org.demo.documentation.feature.excel.inner.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3134PickPickService extends VersionAwareResponseService<MyEntity3134PickPickDTO, MyEntity3134Pick> {

    public MyEntity3134PickPickService() {
        super(MyEntity3134PickPickDTO.class, MyEntity3134Pick.class, null, MyEntity3134PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3134PickPickDTO> doCreateEntity(MyEntity3134Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3134PickPickDTO> doUpdateEntity(MyEntity3134Pick entity, MyEntity3134PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}