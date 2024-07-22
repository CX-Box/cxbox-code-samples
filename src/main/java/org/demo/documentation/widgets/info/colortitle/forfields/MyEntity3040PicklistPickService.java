package org.demo.documentation.widgets.info.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3040PicklistPickService extends VersionAwareResponseService<MyEntity3040PicklistPickDTO, MyEntity3040Picklist> {

    public MyEntity3040PicklistPickService() {
        super(MyEntity3040PicklistPickDTO.class, MyEntity3040Picklist.class, null, MyEntity3040PicklistPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3040PicklistPickDTO> doCreateEntity(MyEntity3040Picklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3040PicklistPickDTO> doUpdateEntity(MyEntity3040Picklist entity, MyEntity3040PicklistPickDTO data,
                                                                          BusinessComponent bc) {
        return null;
    }


}