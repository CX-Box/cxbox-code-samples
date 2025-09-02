package org.demo.documentation.widgets.headerwidget.colortitle.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.headerwidget.colortitle.allfields.enums.CustomFieldMultipleSelectEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5028Service extends VersionAwareResponseService<MyExample5028DTO, MyEntity5028> {

    private final MyEntity5028Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample5028Meta> meta = MyExample5028Meta.class;

    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample5028DTO> doCreateEntity(MyEntity5028 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample5028DTO> doUpdateEntity(MyEntity5028 entity, MyExample5028DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample5028DTO_.customFieldHidden, entity::setCustomFieldHidden);
        setIfChanged(data, MyExample5028DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample5028DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
        setIfChanged(data, MyExample5028DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        setIfChanged(data, MyExample5028DTO_.customFieldDate, entity::setCustomFieldDate);
        setIfChanged(data, MyExample5028DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
        setIfChanged(data, MyExample5028DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample5028DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
        setIfChanged(data, MyExample5028DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
        setIfChanged(data, MyExample5028DTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyExample5028DTO_.customFieldPercent, entity::setCustomFieldPercent);
        if (data.isFieldChanged(MyExample5028DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity5028Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample5028DTO_.customFieldInlineId)) {
            entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
                    ? entityManager.getReference(MyEntity5028Pick.class, data.getCustomFieldInlineId())
                    : null);
        }
        setIfChanged(data, MyExample5028DTO_.customFieldMoney, entity::setCustomFieldMoney);
        setIfChanged(data, MyExample5028DTO_.customFieldRadio, entity::setCustomFieldRadio);
        if (data.isFieldChanged(MyExample5028DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample5028DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity5028Multi.class, e))
                    .collect(Collectors.toList()));
        }
        setIfChanged(data, MyExample5028DTO_.customFieldHint, entity::setCustomFieldHint);
        if (data.isFieldChanged(MyExample5028DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity5028Multi.class, e))
                    .collect(Collectors.toList()));
        }
        setIfChanged(data, MyExample5028DTO_.customField, entity::setCustomField);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample5028DTO> getActions() {
        return Actions.<MyExample5028DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}