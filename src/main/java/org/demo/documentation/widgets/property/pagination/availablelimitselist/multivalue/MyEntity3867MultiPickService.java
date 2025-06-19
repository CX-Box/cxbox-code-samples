package org.demo.documentation.widgets.property.pagination.availablelimitselist.multivalue;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3867MultiPickService extends VersionAwareResponseService<MyEntity3867MultiPickDTO, MyEntity3867Multi> {

    public MyEntity3867MultiPickService() {
        super(MyEntity3867MultiPickDTO.class, MyEntity3867Multi.class, null, MyEntity3867MultiPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3867MultiPickDTO> doCreateEntity(MyEntity3867Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3867MultiPickDTO> doUpdateEntity(MyEntity3867Multi entity, MyEntity3867MultiPickDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}