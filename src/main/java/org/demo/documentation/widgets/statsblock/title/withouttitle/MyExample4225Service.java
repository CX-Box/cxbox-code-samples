package org.demo.documentation.widgets.statsblock.title.withouttitle;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;

@Service
public class MyExample4225Service extends AnySourceVersionAwareResponseService<MyExample4225DTO, MyExample4225DTO> {


    public MyExample4225Service() {
        super(MyExample4225DTO.class, MyExample4225DTO.class, MyExample4225Meta.class, MyExample4225Dao.class);
    }

    @Override
    protected CreateResult<MyExample4225DTO> doCreateEntity(MyExample4225DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }


    @Override
    protected ActionResultDTO<MyExample4225DTO> doUpdateEntity(MyExample4225DTO entity, MyExample4225DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}
