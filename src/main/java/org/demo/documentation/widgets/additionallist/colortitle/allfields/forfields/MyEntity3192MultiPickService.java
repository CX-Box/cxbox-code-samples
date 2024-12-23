package org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3192MultiPickService extends VersionAwareResponseService<MyEntity3192MultiPickDTO, MyEntity3192Multi> {

    public MyEntity3192MultiPickService() {
        super(MyEntity3192MultiPickDTO.class, MyEntity3192Multi.class, null, MyEntity3192MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3192MultiPickDTO> doCreateEntity(MyEntity3192Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3192MultiPickDTO> doUpdateEntity(MyEntity3192Multi entity, MyEntity3192MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}