package org.demo.documentation.other.alltypes;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity423PickService extends VersionAwareResponseService<MyEntity423PickDTO, MyEntity423> {

    public MyEntity423PickService() {
        super(MyEntity423PickDTO.class, MyEntity423.class, null, MyEntity423PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity423PickDTO> doCreateEntity(MyEntity423 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity423PickDTO> doUpdateEntity(MyEntity423 entity, MyEntity423PickDTO data,
                                                                 BusinessComponent bc) {
        return null;
    }


}