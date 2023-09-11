package org.demo.documentation.other.alltypes;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity422MultivalueService extends VersionAwareResponseService<MyEntity422MultivalueDTO, MyEntity422> {

    public MyEntity422MultivalueService() {
        super(MyEntity422MultivalueDTO.class, MyEntity422.class, null, MyEntity422MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity422MultivalueDTO> doCreateEntity(MyEntity422 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity422MultivalueDTO> doUpdateEntity(MyEntity422 entity, MyEntity422MultivalueDTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}