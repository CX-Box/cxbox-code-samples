package org.demo.documentation.feature.microservice.nextandprevioussmart;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@Service
public class MyExample3861Service extends AnySourceVersionAwareResponseService<MyExample3861DTO, MyEntity3861OutServiceDTO> {


    public MyExample3861Service() {
        super(MyExample3861DTO.class, MyEntity3861OutServiceDTO.class,  MyExample3861Meta.class, MyEntity3861Dao.class);

    }

    @Override
    protected CreateResult<MyExample3861DTO> doCreateEntity(MyEntity3861OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3861DTO> doUpdateEntity(MyEntity3861OutServiceDTO entity, MyExample3861DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3861DTO> getActions() {
        return Actions.<MyExample3861DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}