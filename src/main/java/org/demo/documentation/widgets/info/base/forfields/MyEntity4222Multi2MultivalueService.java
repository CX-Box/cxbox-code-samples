package org.demo.documentation.widgets.info.base.forfields;

import lombok.Getter;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4222Multi2MultivalueService extends VersionAwareResponseService<MyEntity4222Multi2MultivalueDTO,  MyEntity4222Multi2> {

    public MyEntity4222Multi2MultivalueService() {
        super(MyEntity4222Multi2MultivalueDTO.class,  MyEntity4222Multi2.class, null, MyEntity4222Multi2MultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4222Multi2MultivalueDTO> doCreateEntity( MyEntity4222Multi2 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4222Multi2MultivalueDTO> doUpdateEntity( MyEntity4222Multi2 entity, MyEntity4222Multi2MultivalueDTO data,
                                                                              BusinessComponent bc) {
        return null;
    }


}