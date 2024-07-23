package org.demo.documentation.widgets.list.colortitle.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3050PicklistPickService extends VersionAwareResponseService<MyEntity3050PicklistPickDTO, MyEntity3050Picklist> {

    public MyEntity3050PicklistPickService() {
        super(MyEntity3050PicklistPickDTO.class, MyEntity3050Picklist.class, null, MyEntity3050PicklistPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3050PicklistPickDTO> doCreateEntity(MyEntity3050Picklist entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3050PicklistPickDTO> doUpdateEntity(MyEntity3050Picklist entity, MyEntity3050PicklistPickDTO data,
                                                                          BusinessComponent bc) {
        return null;
    }


}