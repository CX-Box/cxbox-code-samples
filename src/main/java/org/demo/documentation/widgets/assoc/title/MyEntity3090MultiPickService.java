package org.demo.documentation.widgets.assoc.title;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3090MultiPickService extends VersionAwareResponseService<MyEntity3090MultiPickDTO, MyEntity3090Multi> {

    public MyEntity3090MultiPickService() {
        super(MyEntity3090MultiPickDTO.class, MyEntity3090Multi.class, null, MyEntity3090MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3090MultiPickDTO> doCreateEntity(MyEntity3090Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3090MultiPickDTO> doUpdateEntity(MyEntity3090Multi entity, MyEntity3090MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}