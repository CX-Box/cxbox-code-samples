package org.demo.documentation.widgets.additionalinfo.colortitle;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3029;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3030;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3034;
import org.demo.documentation.widgets.additionalinfo.colortitle.forfields.MyEntity3035;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MyExample3025Service extends VersionAwareResponseService<MyExample3025DTO, MyEntity3025> {

    private final MyEntity3025Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3025Service(MyEntity3025Repository repository) {
        super(MyExample3025DTO.class, MyEntity3025.class, null, MyExample3025Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3025DTO> doCreateEntity(MyEntity3025 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3025DTO> doUpdateEntity(MyEntity3025 entity, MyExample3025DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorMultivalue)) {
            entity.getCustomFieldColorMultivalueList().clear();
            entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3035.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorMultivalueHover)) {
            entity.getCustomFieldColorMultivalueHoverList().clear();
            entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3034.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorInlinePicklistId)) {
            entity.setCustomFieldColorInlinePicklistEntity(data.getCustomFieldColorInlinePicklistId() != null
                    ? entityManager.getReference(MyEntity3030.class, data.getCustomFieldColorInlinePicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorPicklistId)) {
            entity.setCustomFieldColorPicklistEntity(data.getCustomFieldColorPicklistId() != null
                    ? entityManager.getReference(MyEntity3029.class, data.getCustomFieldColorPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorRadio)) {
            entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorMoney)) {
            entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorPercent)) {
            entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorNumber)) {
            entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorFileUploadeId)) {
            entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorFileUploade)) {
            entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorDictionary)) {
            entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorDateTimeWithSeconds)) {
            entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorDate)) {
            entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorCheckbox)) {
            entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorDateTime)) {
            entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorText)) {
            entity.setCustomFieldColorText(data.getCustomFieldColorText());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customFieldColorInput)) {
            entity.setCustomFieldColorInput(data.getCustomFieldColorInput());
        }
        if (data.isFieldChanged(MyExample3025DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3025DTO> getActions() {
        return Actions.<MyExample3025DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
