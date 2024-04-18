package org.demo.documentation.microservice.existingmicroservices;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.springframework.stereotype.Service;


@Service
public class MyExample3800Service extends AnySourceVersionAwareResponseService<MyExample3800DTO, MyEntity3800OutServiceDTO> {

    public MyExample3800Service() {
        super(MyExample3800DTO.class, MyEntity3800OutServiceDTO.class,  MyExample3800Meta.class, MyEntity3800Dao.class);
    }

    @Override
    protected CreateResult<MyExample3800DTO> doCreateEntity(MyEntity3800OutServiceDTO entity, BusinessComponent bc) {

        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3800DTO> doUpdateEntity(MyEntity3800OutServiceDTO entity, MyExample3800DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3800DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3800DTO> getActions() {
        return Actions.<MyExample3800DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}