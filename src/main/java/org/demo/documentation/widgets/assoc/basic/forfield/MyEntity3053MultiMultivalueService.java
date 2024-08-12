package org.demo.documentation.widgets.assoc.basic.forfield;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3053MultiMultivalueService extends VersionAwareResponseService<MyEntity3053MultiMultivalueDTO, org.demo.documentation.widgets.assoc.basic.forfield.MyEntity3053Multi> {

    public MyEntity3053MultiMultivalueService() {
        super(MyEntity3053MultiMultivalueDTO.class, MyEntity3053Multi.class, null, MyEntity3053MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3053MultiMultivalueDTO> doCreateEntity(MyEntity3053Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3053MultiMultivalueDTO> doUpdateEntity(MyEntity3053Multi entity, MyEntity3053MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}