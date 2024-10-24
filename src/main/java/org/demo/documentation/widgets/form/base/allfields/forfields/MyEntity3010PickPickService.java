package org.demo.documentation.widgets.form.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3010PickPickService extends VersionAwareResponseService<MyEntity3010PickPickDTO, MyEntity3010Pick> {

    public MyEntity3010PickPickService() {
        super(MyEntity3010PickPickDTO.class, MyEntity3010Pick.class, null, MyEntity3010PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3010PickPickDTO> doCreateEntity(MyEntity3010Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3010PickPickDTO> doUpdateEntity(MyEntity3010Pick entity, MyEntity3010PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}