package org.demo.documentation.widgets.list.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3002MultivalueService extends VersionAwareResponseService<MyEntity3002MultivalueDTO, MyEntity3002Multi> {

    public MyEntity3002MultivalueService() {
        super(MyEntity3002MultivalueDTO.class, MyEntity3002Multi.class, null, MyEntity3002MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3002MultivalueDTO> doCreateEntity(MyEntity3002Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3002MultivalueDTO> doUpdateEntity(MyEntity3002Multi entity, MyEntity3002MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}