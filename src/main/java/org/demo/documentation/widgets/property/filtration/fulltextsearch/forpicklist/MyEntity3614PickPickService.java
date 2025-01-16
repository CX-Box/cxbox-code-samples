package org.demo.documentation.widgets.property.filtration.fulltextsearch.forpicklist;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3614PickPickService extends VersionAwareResponseService<MyEntity3614PickPickDTO, MyEntity3614Pick> {

    public MyEntity3614PickPickService() {
        super(MyEntity3614PickPickDTO.class, MyEntity3614Pick.class, null, MyEntity3614PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3614PickPickDTO> doCreateEntity(MyEntity3614Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3614PickPickDTO> doUpdateEntity(MyEntity3614Pick entity, MyEntity3614PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}