package org.demo.documentation.widgets.assoc.actions.buttonassoc;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3062MultiMultivalueService extends VersionAwareResponseService<MyEntity3062MultiMultivalueDTO, MyEntity3062Multi> {

    public MyEntity3062MultiMultivalueService() {
        super(MyEntity3062MultiMultivalueDTO.class, MyEntity3062Multi.class, null, MyEntity3062MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3062MultiMultivalueDTO> doCreateEntity(MyEntity3062Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3062MultiMultivalueDTO> doUpdateEntity(MyEntity3062Multi entity, MyEntity3062MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}