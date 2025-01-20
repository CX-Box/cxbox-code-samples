package org.demo.documentation.widgets.statsblock.showcondition;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4230Service extends AnySourceVersionAwareResponseService<MyExample4230DTO, MyExample4230DTO> {


    public MyExample4230Service() {
        super(MyExample4230DTO.class, MyExample4230DTO.class, MyExample4230Meta.class, MyExample4230Dao.class);
    }

    @Override
    protected CreateResult<MyExample4230DTO> doCreateEntity(MyExample4230DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyExample4230DTO> doUpdateEntity(MyExample4230DTO entity, MyExample4230DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
