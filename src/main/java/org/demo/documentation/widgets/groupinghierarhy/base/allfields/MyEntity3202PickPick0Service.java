package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;


@Getter
@Service
public class MyEntity3202PickPick0Service extends VersionAwareResponseService<MyEntity3202PickPick0DTO, MyEntity3202Pick> {

    public MyEntity3202PickPick0Service() {
        super(MyEntity3202PickPick0DTO.class, MyEntity3202Pick.class, null, MyEntity3202PickPick0Meta.class);
    }

    @Override
    protected CreateResult<MyEntity3202PickPick0DTO> doCreateEntity(MyEntity3202Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3202PickPick0DTO> doUpdateEntity(MyEntity3202Pick entity, MyEntity3202PickPick0DTO data,
                                                                       BusinessComponent bc) {
        return null;
    }


}