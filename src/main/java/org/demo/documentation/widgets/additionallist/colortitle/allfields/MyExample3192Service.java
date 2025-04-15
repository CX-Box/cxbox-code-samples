package org.demo.documentation.widgets.additionallist.colortitle.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192Multi;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192MultiHover;
import org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields.MyEntity3192Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3192Service extends VersionAwareResponseService<MyExample3192DTO, MyEntity3192> {

    private final MyEntity3192Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3192Meta> meta = MyExample3192Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3192DTO> doCreateEntity(MyEntity3192 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3192DTO> doUpdateEntity(MyEntity3192 entity, MyExample3192DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3192DTO_.customFieldHidden, entity::setCustomFieldHidden);
        setIfChanged(data, MyExample3192DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample3192DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
        setIfChanged(data, MyExample3192DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        setIfChanged(data, MyExample3192DTO_.customFieldDate, entity::setCustomFieldDate);
        setIfChanged(data, MyExample3192DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
        setIfChanged(data, MyExample3192DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
        setIfChanged(data, MyExample3192DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample3192DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
        setIfChanged(data, MyExample3192DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
        setIfChanged(data, MyExample3192DTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyExample3192DTO_.customFieldPercent, entity::setCustomFieldPercent);
        if (data.isFieldChanged(MyExample3192DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3192Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3192DTO_.customFieldInlineId)) {
            entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
                    ? entityManager.getReference(MyEntity3192Pick.class, data.getCustomFieldInlineId())
                    : null);
        }
        setIfChanged(data, MyExample3192DTO_.customFieldMoney, entity::setCustomFieldMoney);
        setIfChanged(data, MyExample3192DTO_.customFieldRadio, entity::setCustomFieldRadio);
        if (data.isFieldChanged(MyExample3192DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample3192DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3192Multi.class, e))
                    .toList());
        }
        setIfChanged(data, MyExample3192DTO_.customFieldHint, entity::setCustomFieldHint);
        if (data.isFieldChanged(MyExample3192DTO_.customFieldMultivalueHoverDisplayedKey)) {
            entity.getCustomFieldMultivalueHoverDisplayedKeyList().clear();
            entity.getCustomFieldMultivalueHoverDisplayedKeyList().addAll(data.getCustomFieldMultivalueHoverDisplayedKey().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3192MultiHover.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample3192DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3192DTO> getActions() {
        return Actions.<MyExample3192DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

