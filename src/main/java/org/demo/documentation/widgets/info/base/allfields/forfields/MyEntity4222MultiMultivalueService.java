package org.demo.documentation.widgets.info.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4222MultiMultivalueService extends VersionAwareResponseService<MyEntity4222MultiMultivalueDTO, MyEntity4222Multi> {

    public MyEntity4222MultiMultivalueService() {
        super(MyEntity4222MultiMultivalueDTO.class, MyEntity4222Multi.class, null, MyEntity4222MultiMultivalueMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4222MultiMultivalueDTO> doCreateEntity(MyEntity4222Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4222MultiMultivalueDTO> doUpdateEntity(MyEntity4222Multi entity, MyEntity4222MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        return null;
    }


}