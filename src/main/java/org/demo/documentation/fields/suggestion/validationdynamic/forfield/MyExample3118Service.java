package org.demo.documentation.fields.suggestion.validationdynamic.forfield;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.BusinessError;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.exception.BusinessException;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.fields.text.validationdynamic.MyExample332DTO_;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "EmptyMethod"})
@RequiredArgsConstructor
@Service
public class MyExample3118Service extends VersionAwareResponseService<MyExample3118DTO, MyEntity3118> {

    private final MyEntity3118Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3118Meta> meta = MyExample3118Meta.class;

    @Override
    protected CreateResult<MyExample3118DTO> doCreateEntity(MyEntity3118 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3118DTO> doUpdateEntity(MyEntity3118 entity, MyExample3118DTO data, BusinessComponent bc) {
        validateFields(bc, data);
        if (data.isFieldChanged(MyExample3118DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3118DTO> getActions() {
        return Actions.<MyExample3118DTO>builder()
               .save(sv -> sv.text("Save"))
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
        if (!entity.getFields().isEmpty()) {
            throw new BusinessException().setEntity(entity);
        }
    }
    // --8<-- [end:validateFields]

}

