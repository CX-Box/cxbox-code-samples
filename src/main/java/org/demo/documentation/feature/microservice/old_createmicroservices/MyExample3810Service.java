package org.demo.documentation.feature.microservice.old_createmicroservices;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
 import org.springframework.stereotype.Service;


@Service
public class MyExample3810Service extends AnySourceVersionAwareResponseService<MyExample3810DTO, MyEntity3810OutServiceDTO> {


    public MyExample3810Service() {
        super(MyExample3810DTO.class, MyEntity3810OutServiceDTO.class,  MyExample3810Meta.class, MyEntity3810Dao.class);

    }

    @Override
    protected CreateResult<MyExample3810DTO> doCreateEntity(MyEntity3810OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3810DTO> doUpdateEntity(MyEntity3810OutServiceDTO entity, MyExample3810DTO data, BusinessComponent bc) {

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3810DTO> getActions() {
        return Actions.<MyExample3810DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}