package org.demo.documentation.widgets.property.filtration.filtergroupsave.forpicklist;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3618PickPickService extends VersionAwareResponseService<MyEntity3618PickPickDTO, MyEntity3618Pick> {

    public MyEntity3618PickPickService() {
        super(MyEntity3618PickPickDTO.class, MyEntity3618Pick.class, null, MyEntity3618PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3618PickPickDTO> doCreateEntity(MyEntity3618Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3618PickPickDTO> doUpdateEntity(MyEntity3618Pick entity, MyEntity3618PickPickDTO data,
                                                                      BusinessComponent bc) {
        return null;
    }


}