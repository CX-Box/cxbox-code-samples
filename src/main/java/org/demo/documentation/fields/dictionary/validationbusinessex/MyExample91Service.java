package org.demo.documentation.fields.dictionary.validationbusinessex;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.dictionary.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import static org.demo.documentation.fields.main.TextError.ONLY_HIGH;


@Service
public class MyExample91Service extends VersionAwareResponseService<MyExample91DTO, MyEntity91> {

    private final MyEntity91Repository repository;

    public MyExample91Service(MyEntity91Repository repository) {
        super(MyExample91DTO.class, MyEntity91.class, null, MyExample91Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample91DTO> doCreateEntity(MyEntity91 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample91DTO> doUpdateEntity(MyEntity91 entity, MyExample91DTO data,
                                                             BusinessComponent bc) {
        if (data.isFieldChanged(MyExample91DTO_.customField)) {
            if (data.getCustomField() != null && !CustomFieldEnum.HIGH.getValue().equals(data.getCustomField().getValue())) {
                throw new BusinessException().addPopup(ONLY_HIGH);
            }
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample91DTO> getActions() {
        return Actions.<MyExample91DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}