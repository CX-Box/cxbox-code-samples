package org.demo.documentation.widgets.assoc.actions.customsave;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3063MultiMultivalueService extends VersionAwareResponseService<MyEntity3063MultiMultivalueDTO, MyEntity3063Multi> {

    public MyEntity3063MultiMultivalueService() {
        super(MyEntity3063MultiMultivalueDTO.class, MyEntity3063Multi.class, null, MyEntity3063MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3063MultiMultivalueDTO> doCreateEntity(MyEntity3063Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3063MultiMultivalueDTO> doUpdateEntity(MyEntity3063Multi entity, MyEntity3063MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}