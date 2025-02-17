package org.demo.documentation.widgets.property.pagination.nextandpreviouswihhasnext;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3860Service extends AnySourceVersionAwareResponseService<MyExample3860DTO, MyEntity3860OutServiceDTO> {


    public MyExample3860Service() {
        super(MyExample3860DTO.class, MyEntity3860OutServiceDTO.class,  MyExample3860Meta.class, MyEntity3860Dao.class);

    }

    @Override
    protected CreateResult<MyExample3860DTO> doCreateEntity(MyEntity3860OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3860DTO> doUpdateEntity(MyEntity3860OutServiceDTO entity, MyExample3860DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3860DTO> getActions() {
        return Actions.<MyExample3860DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}