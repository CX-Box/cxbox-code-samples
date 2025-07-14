package org.demo.documentation.widgets.list.customizationcolumns;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.demo.documentation.widgets.list.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.list.customizationcolumns.forfields.MyEntity3135InlinePick;
import org.demo.documentation.widgets.list.customizationcolumns.forfields.MyEntity3135Multi;
import org.demo.documentation.widgets.list.customizationcolumns.forfields.MyEntity3135MultiHover;
import org.demo.documentation.widgets.list.customizationcolumns.forfields.MyEntity3135Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3135Service extends VersionAwareResponseService<MyExample3135DTO, MyEntity3135> {

    private final MyEntity3135Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3135Meta> meta = MyExample3135Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3135DTO> doCreateEntity(MyEntity3135 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3135DTO> doUpdateEntity(MyEntity3135 entity, MyExample3135DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3135DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3135MultiHover.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3135DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample3135DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3135Multi.class, e))
                    .toList());
        }
        setIfChanged(data, MyExample3135DTO_.customFieldHidden, entity::setCustomFieldHidden);
        setIfChanged(data, MyExample3135DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample3135DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
        setIfChanged(data, MyExample3135DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
        setIfChanged(data, MyExample3135DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
        setIfChanged(data, MyExample3135DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
        setIfChanged(data, MyExample3135DTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyExample3135DTO_.customFieldPercent, entity::setCustomFieldPercent);
        if (data.isFieldChanged(MyExample3135DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3135Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3135DTO_.customFieldInlineId)) {
            entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
                    ? entityManager.getReference(MyEntity3135InlinePick.class, data.getCustomFieldInlineId())
                    : null);
        }
        setIfChanged(data, MyExample3135DTO_.customFieldMoney, entity::setCustomFieldMoney);
        setIfChanged(data, MyExample3135DTO_.customFieldRadio, entity::setCustomFieldRadio);
        if (data.isFieldChanged(MyExample3135DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample3135DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3135Multi.class, e))
                    .toList());
        }
        setIfChanged(data, MyExample3135DTO_.customFieldHint, entity::setCustomFieldHint);
        if (data.isFieldChanged(MyExample3135DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3135MultiHover.class, e))
                    .toList());
        }
        setIfChanged(data, MyExample3135DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample3135DTO_.customFieldCheckBox, entity::setCustomFieldCheckBox);
        setIfChanged(data, MyExample3135DTO_.customFieldDate, entity::setCustomFieldDate);
        setIfChanged(data, MyExample3135DTO_.customFieldInput, entity::setCustomFieldInput);
        if (data.isFieldChanged(MyExample3135DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3135DTO> getActions() {
        return Actions.<MyExample3135DTO>builder()
               .save(sv -> sv.text("Save"))
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
     // --8<-- [end:getActions]  
}
