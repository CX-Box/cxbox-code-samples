package org.demo.documentation.feature.excel.inner.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3134MultiMultivalueService extends VersionAwareResponseService<MyEntity3134MultiMultivalueDTO, MyEntity3134Multi> {

    public MyEntity3134MultiMultivalueService() {
        super(MyEntity3134MultiMultivalueDTO.class, MyEntity3134Multi.class, null, MyEntity3134MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3134MultiMultivalueDTO> doCreateEntity(MyEntity3134Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3134MultiMultivalueDTO> doUpdateEntity(MyEntity3134Multi entity, MyEntity3134MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}