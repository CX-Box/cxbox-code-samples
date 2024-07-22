package org.demo.documentation.widgets.form.colortitle.forfields;

import lombok.Getter;
import org.demo.documentation.widgets.form.colortitle.MyEntity3032;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3032PickService extends VersionAwareResponseService<MyEntity3032PickDTO, MyEntity3032> {

    public MyEntity3032PickService() {
        super(MyEntity3032PickDTO.class, MyEntity3032.class, null, MyEntity3032PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3032PickDTO> doCreateEntity(MyEntity3032 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3032PickDTO> doUpdateEntity(MyEntity3032 entity, MyEntity3032PickDTO data,
                                                                  BusinessComponent bc) {
        return null;
    }


}