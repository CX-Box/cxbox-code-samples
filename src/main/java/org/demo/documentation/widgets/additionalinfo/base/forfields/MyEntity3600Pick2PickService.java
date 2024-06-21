package org.demo.documentation.widgets.additionalinfo.base.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3600Pick2PickService extends VersionAwareResponseService<MyEntity3600Pick2PickDTO, MyEntity3600Pick2> {

    public MyEntity3600Pick2PickService() {
        super(MyEntity3600Pick2PickDTO.class, MyEntity3600Pick2.class, null, MyEntity3600Pick2PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3600Pick2PickDTO> doCreateEntity(MyEntity3600Pick2 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3600Pick2PickDTO> doUpdateEntity(MyEntity3600Pick2 entity, MyEntity3600Pick2PickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}