package org.demo.documentation.widgets.statsblock.base.customfields;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Service
public class MyExample4200Service extends AnySourceVersionAwareResponseService<MyExample4200DTO, MyExample4200DTO> {


    public MyExample4200Service( ) {
        super(MyExample4200DTO.class, MyExample4200DTO.class, MyExample4200Meta.class, MyExample4200Dao.class);

    }

    @Override
    protected CreateResult<MyExample4200DTO> doCreateEntity(MyExample4200DTO entity, BusinessComponent bc) {

        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4200DTO> doUpdateEntity(MyExample4200DTO entity, MyExample4200DTO data, BusinessComponent bc) {
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }



}