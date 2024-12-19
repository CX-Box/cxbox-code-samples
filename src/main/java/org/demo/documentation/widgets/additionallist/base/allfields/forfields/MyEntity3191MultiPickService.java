package org.demo.documentation.widgets.additionallist.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3191MultiPickService extends VersionAwareResponseService<MyEntity3191MultiPickDTO, MyEntity3191Multi> {

    public MyEntity3191MultiPickService() {
        super(MyEntity3191MultiPickDTO.class, MyEntity3191Multi.class, null, MyEntity3191MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3191MultiPickDTO> doCreateEntity(MyEntity3191Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3191MultiPickDTO> doUpdateEntity(MyEntity3191Multi entity, MyEntity3191MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}