package org.demo.documentation.widgets.statsblock.color.color;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;

import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

import org.springframework.stereotype.Service;


@Service
public class MyExample4205Service extends AnySourceVersionAwareResponseService<MyExample4205DTO, MyExample4205DTO> {


    public MyExample4205Service() {
        super(MyExample4205DTO.class, MyExample4205DTO.class, MyExample4205Meta.class, MyExample4205Dao.class);

    }

    @Override
    protected CreateResult<MyExample4205DTO> doCreateEntity(MyExample4205DTO entity, BusinessComponent bc) {

        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4205DTO> doUpdateEntity(MyExample4205DTO entity, MyExample4205DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
}