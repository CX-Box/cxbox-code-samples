package org.demo.documentation.getstarted.microservice.example;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.getstarted.microservice.MyEntity4001OutServiceDTO;
import org.springframework.stereotype.Service;


@Service
public class MyExample4001Service extends AnySourceVersionAwareResponseService<MyExample4001DTO, MyEntity4001OutServiceDTO> {

    public MyExample4001Service() {
        super(MyExample4001DTO.class, MyEntity4001OutServiceDTO.class, null, MyEntity4001Dao.class);
    }

    @Override
    protected CreateResult<MyExample4001DTO> doCreateEntity(MyEntity4001OutServiceDTO entity, BusinessComponent bc) {
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4001DTO> doUpdateEntity(MyEntity4001OutServiceDTO entity, MyExample4001DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4001DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4001DTO> getActions() {
        return Actions.<MyExample4001DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}