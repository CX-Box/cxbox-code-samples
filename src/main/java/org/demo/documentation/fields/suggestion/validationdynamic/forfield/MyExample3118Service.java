package org.demo.documentation.fields.suggestion.validationdynamic.forfield;

import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.text.validationdynamic.MyExample332DTO;
import org.demo.documentation.fields.text.validationdynamic.MyExample332DTO_;
import org.springframework.stereotype.Service;

@Service
public class MyExample3118Service extends VersionAwareResponseService<MyExample3118DTO, MyEntity3118> {

    private final MyEntity3118Repository repository;

    public MyExample3118Service(MyEntity3118Repository repository) {
        super(MyExample3118DTO.class, MyEntity3118.class, null, MyExample3118Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3118DTO> doCreateEntity(MyEntity3118 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3118DTO> doUpdateEntity(MyEntity3118 entity, MyExample3118DTO data, BusinessComponent bc) {
        validateFields(bc, data);
        if (data.isFieldChanged(MyExample3118DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3118DTO> getActions() {
        return Actions.<MyExample3118DTO>builder()
                .newAction()
                .action("save", "save")
                .add()
                .build();
    }
    // --8<-- [start:validateFields]
    private void validateFields(BusinessComponent bc, MyExample3118DTO dto) {
        BusinessError.Entity entity = new BusinessError.Entity(bc);
        if (!String.valueOf(dto.getCustomField()).matches("[A-Za-z]+")) {
            entity.addField(MyExample332DTO_.customField.getName(), "The field 'customField' can contain only letters.");
        }
        if (!String.valueOf(dto.getCustomFieldAdditional()).matches("[A-Za-z]+")) {
            entity.addField(
                    MyExample332DTO_.customFieldAdditional.getName(),
                    "The field 'customFieldAdditional' can contain only letters."
            );
        }
        if (entity.getFields().size() > 0) {
            throw new BusinessException().setEntity(entity);
        }
    }
    // --8<-- [end:validateFields]

}

