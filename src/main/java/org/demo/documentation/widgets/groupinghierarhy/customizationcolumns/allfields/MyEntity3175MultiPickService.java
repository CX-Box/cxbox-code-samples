package org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3175MultiPickService extends VersionAwareResponseService<MyEntity3175MultiPickDTO, org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Multi> {

    public MyEntity3175MultiPickService() {
        super(MyEntity3175MultiPickDTO.class, org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Multi.class, null, MyEntity3175MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3175MultiPickDTO> doCreateEntity(org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3175MultiPickDTO> doUpdateEntity(org.demo.documentation.widgets.groupinghierarhy.customizationcolumns.allfields.MyEntity3175Multi entity, MyEntity3175MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}