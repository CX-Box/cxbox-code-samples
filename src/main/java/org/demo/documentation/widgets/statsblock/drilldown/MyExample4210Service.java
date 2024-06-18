package org.demo.documentation.widgets.statsblock.drilldown;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@Service
public class MyExample4210Service extends AnySourceVersionAwareResponseService<MyExample4210DTO, MyExample4210DTO> {


    public MyExample4210Service( ) {
        super(MyExample4210DTO.class, MyExample4210DTO.class,  MyExample4210Meta.class, MyExample4210Dao.class);
    }

    @Override
    protected CreateResult<MyExample4210DTO> doCreateEntity(MyExample4210DTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4210DTO> doUpdateEntity(MyExample4210DTO entity, MyExample4210DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4210DTO> getActions() {
        return Actions.<MyExample4210DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}