package org.demo.documentation.widgets.statsblock.base.defaultfields;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Service
public class MyExample4203Service extends AnySourceVersionAwareResponseService<MyExample4203DTO, MyExample4203DTO> {


    public MyExample4203Service() {
        super(MyExample4203DTO.class, MyExample4203DTO.class, MyExample4203Meta.class, MyExample4203Dao.class);

    }

    @Override
    protected CreateResult<MyExample4203DTO> doCreateEntity(MyExample4203DTO entity, BusinessComponent bc) {

        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4203DTO> doUpdateEntity(MyExample4203DTO entity, MyExample4203DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

}
