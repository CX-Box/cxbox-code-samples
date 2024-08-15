package org.demo.documentation.widgets.assoc.actions.createwithparent;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3663MultivalueService extends VersionAwareResponseService<MyEntity3663MultivalueDTO, org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3663> {

    public MyEntity3663MultivalueService() {
        super(MyEntity3663MultivalueDTO.class, org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3663.class, null, MyEntity3663MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3663MultivalueDTO> doCreateEntity(org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3663 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3663MultivalueDTO> doUpdateEntity(org.demo.documentation.widgets.assoc.actions.createwithparent.parent.MyEntity3663 entity, MyEntity3663MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}