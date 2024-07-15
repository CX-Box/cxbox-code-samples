package org.demo.documentation.fields.multivalue.primary;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity2001MultivalueService extends VersionAwareResponseService<MyEntity2001MultivalueDTO, MyEntity2001> {

    public MyEntity2001MultivalueService() {
        super(MyEntity2001MultivalueDTO.class, MyEntity2001.class, null, MyEntity2001MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity2001MultivalueDTO> doCreateEntity(MyEntity2001 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity2001MultivalueDTO> doUpdateEntity(MyEntity2001 entity, MyEntity2001MultivalueDTO data,
                                                                        BusinessComponent bc) {
        return null;
    }


}