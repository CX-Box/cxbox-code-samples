package org.demo.documentation.fields.multivaluehover.required;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity238PickService extends VersionAwareResponseService<MyEntity238PickDTO, MyEntity238> {

    public MyEntity238PickService() {
        super(MyEntity238PickDTO.class, MyEntity238.class, null, MyEntity238PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity238PickDTO> doCreateEntity(MyEntity238 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity238PickDTO> doUpdateEntity(MyEntity238 entity, MyEntity238PickDTO data,
                                                                 BusinessComponent bc) {
        return null;
    }


}