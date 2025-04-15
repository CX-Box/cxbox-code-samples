package org.demo.documentation.widgets.form.colortitle;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.form.colortitle.forfields.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3026Service extends VersionAwareResponseService<MyExample3026DTO, MyEntity3026> {

    private final MyEntity3026Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3026Meta> meta = MyExample3026Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3026DTO> doCreateEntity(MyEntity3026 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3026DTO> doUpdateEntity(MyEntity3026 entity, MyExample3026DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorMultivalue)) {
            entity.getCustomFieldColorMultivalueList().clear();
            entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3038.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorMultivalueHover)) {
            entity.getCustomFieldColorMultivalueHoverList().clear();
            entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3037.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorMultivalueHover)) {
            entity.getCustomFieldColorMultivalueHoverList().clear();
            entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3037.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorMultivalue)) {
            entity.getCustomFieldColorMultivalueList().clear();
            entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3038.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorInput)) {
            entity.setCustomFieldColorInput(data.getCustomFieldColorInput());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorText)) {
            entity.setCustomFieldColorText(data.getCustomFieldColorText());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorDateTime)) {
            entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorCheckbox)) {
            entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorDate)) {
            entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorDateTimeWithSeconds)) {
            entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorDictionary)) {
            entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorFileUploadeId)) {
            entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorFileUploade)) {
            entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorNumber)) {
            entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorPercent)) {
            entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorMoney)) {
            entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorRadio)) {
            entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorPicklistId)) {
            entity.setCustomFieldColorPicklistEntity(data.getCustomFieldColorPicklistId() != null
                    ? entityManager.getReference(MyEntity3032.class, data.getCustomFieldColorPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3026DTO_.customFieldColorInlinePicklistId)) {
            entity.setCustomFieldColorInlinePicklistEntity(data.getCustomFieldColorInlinePicklistId() != null
                    ? entityManager.getReference(MyEntity3031.class, data.getCustomFieldColorInlinePicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3026DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3026DTO> getActions() {
        return Actions.<MyExample3026DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
