package org.demo.documentation.widgets.picklist.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3061PickPickPickService extends VersionAwareResponseService<MyEntity3061PickPickPickDTO, MyEntity3061PickPick> {

    public MyEntity3061PickPickPickService() {
        super(MyEntity3061PickPickPickDTO.class, MyEntity3061PickPick.class, null, MyEntity3061PickPickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3061PickPickPickDTO> doCreateEntity(MyEntity3061PickPick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3061PickPickPickDTO> doUpdateEntity(MyEntity3061PickPick entity, MyEntity3061PickPickPickDTO data,
                                                                          BusinessComponent bc) {
        return null;
    }


}