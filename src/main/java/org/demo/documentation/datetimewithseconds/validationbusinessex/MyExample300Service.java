package org.demo.documentation.datetimewithseconds.validationbusinessex;


import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.datetimewithseconds.validationdynamic.MyExample322DTO_;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class MyExample300Service extends VersionAwareResponseService<MyExample300DTO, MyEntity300> {

    private final MyEntity300Repository repository;

    public MyExample300Service(MyEntity300Repository repository) {
        super(MyExample300DTO.class, MyEntity300.class, null, MyExample300Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample300DTO> doCreateEntity(MyEntity300 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample300DTO> doUpdateEntity(MyEntity300 entity, MyExample300DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample300DTO_.customField)) {
            if (data.getCustomField() != null && LocalDateTime.now().isAfter(data.getCustomField())) {
                throw new BusinessException().addPopup("The field 'customField' cannot be less than the current date");
            }
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    @Override
    public Actions<MyExample300DTO> getActions() {
        return Actions.<MyExample300DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }

}