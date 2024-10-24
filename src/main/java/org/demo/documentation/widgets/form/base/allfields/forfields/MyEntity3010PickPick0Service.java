package org.demo.documentation.widgets.form.base.allfields.forfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3010PickPick0Service extends VersionAwareResponseService<MyEntity3010PickPick0DTO, MyEntity3010Pick> {

    public MyEntity3010PickPick0Service() {
        super(MyEntity3010PickPick0DTO.class, MyEntity3010Pick.class, null, MyEntity3010PickPick0Meta.class);
    }

    @Override
    protected CreateResult<MyEntity3010PickPick0DTO> doCreateEntity(MyEntity3010Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3010PickPick0DTO> doUpdateEntity(MyEntity3010Pick entity, MyEntity3010PickPick0DTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}