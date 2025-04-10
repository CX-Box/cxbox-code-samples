package org.demo.documentation.widgets.additionallist.base.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.additionallist.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191Multi;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191MultiHover;
import org.demo.documentation.widgets.additionallist.base.allfields.forfields.MyEntity3191Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3191Service extends VersionAwareResponseService<MyExample3191DTO, MyEntity3191> {

    private final MyEntity3191Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3191Meta> meta = MyExample3191Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3191DTO> doCreateEntity(MyEntity3191 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3191DTO> doUpdateEntity(MyEntity3191 entity, MyExample3191DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3191DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample3191DTO_.customFieldHidden, entity::setCustomFieldHidden);
        setIfChanged(data, MyExample3191DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
        setIfChanged(data, MyExample3191DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        setIfChanged(data, MyExample3191DTO_.customFieldDate, entity::setCustomFieldDate);
        setIfChanged(data, MyExample3191DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
        setIfChanged(data, MyExample3191DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample3191DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
        setIfChanged(data, MyExample3191DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
        setIfChanged(data, MyExample3191DTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyExample3191DTO_.customFieldPercent, entity::setCustomFieldPercent);
        if (data.isFieldChanged(MyExample3191DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3191Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3191DTO_.customFieldInlineId)) {
            entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
                    ? entityManager.getReference(MyEntity3191Pick.class, data.getCustomFieldInlineId())
                    : null);
        }
        setIfChanged(data, MyExample3191DTO_.customFieldMoney, entity::setCustomFieldMoney);
        setIfChanged(data, MyExample3191DTO_.customFieldRadio, entity::setCustomFieldRadio);
        if (data.isFieldChanged(MyExample3191DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample3191DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3191Multi.class, e))
                    .toList());
        }
        setIfChanged(data, MyExample3191DTO_.customFieldHint, entity::setCustomFieldHint);
        if (data.isFieldChanged(MyExample3191DTO_.customFieldMultivalueHoverDisplayedKey)) {
            entity.getCustomFieldMultivalueHoverDisplayedKeyList().clear();
            entity.getCustomFieldMultivalueHoverDisplayedKeyList().addAll(data.getCustomFieldMultivalueHoverDisplayedKey().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3191MultiHover.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3191DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3191DTO> getActions() {
        return Actions.<MyExample3191DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

