package org.demo.documentation.widgets.picklist.base.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3067MultiPickService extends VersionAwareResponseService<MyEntity3067MultiPickDTO, org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi> {

    public MyEntity3067MultiPickService() {
        super(MyEntity3067MultiPickDTO.class, org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi.class, null, MyEntity3067MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3067MultiPickDTO> doCreateEntity(org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3067MultiPickDTO> doUpdateEntity(org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi entity, MyEntity3067MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}