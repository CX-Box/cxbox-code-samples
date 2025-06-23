package org.demo.documentation.other.forceactive2.forproject;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity4903OCPPickPickService extends VersionAwareResponseService<MyEntity4903OCPPickPickDTO, MyEntity4903OCPPick> {

    public MyEntity4903OCPPickPickService() {
        super(MyEntity4903OCPPickPickDTO.class, MyEntity4903OCPPick.class, null, MyEntity4903OCPPickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity4903OCPPickPickDTO> doCreateEntity(MyEntity4903OCPPick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity4903OCPPickPickDTO> doUpdateEntity(MyEntity4903OCPPick entity, MyEntity4903OCPPickPickDTO data,
                                                                         BusinessComponent bc) {
        return null;
    }


}