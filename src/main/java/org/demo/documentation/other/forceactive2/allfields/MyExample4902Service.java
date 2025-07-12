package org.demo.documentation.other.forceactive2.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.forceactive2.allfields.enums.CustomFieldMultipleSelectEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample4902Service extends VersionAwareResponseService<MyExample4902DTO, MyEntity4902> {

    private final MyEntity4902Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample4902Meta> meta = MyExample4902Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample4902DTO> doCreateEntity(MyEntity4902 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample4902DTO> doUpdateEntity(MyEntity4902 entity, MyExample4902DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample4902DTO_.suggestionPickListId)) {
            entity.setSuggestionPickListEntity(data.getSuggestionPickListId() != null
                    ? entityManager.getReference(MyEntity4902Suggection.class, data.getSuggestionPickListId())
                    : null);
        }

        if (data.isFieldChanged(MyExample4902DTO_.customFieldMultivalueNew)) {
            entity.getCustomFieldMultivalueNewList().clear();
            entity.getCustomFieldMultivalueNewList().addAll(data.getCustomFieldMultivalueNew().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity4902Multi.class, e))
                    .collect(Collectors.toList()));
        }
        setIfChanged(data, MyExample4902DTO_.customFieldHidden, entity::setCustomFieldHidden);
        setIfChanged(data, MyExample4902DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample4902DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
        setIfChanged(data, MyExample4902DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        setIfChanged(data, MyExample4902DTO_.customFieldDate, entity::setCustomFieldDate);
        setIfChanged(data, MyExample4902DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
        setIfChanged(data, MyExample4902DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample4902DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
        setIfChanged(data, MyExample4902DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
        setIfChanged(data, MyExample4902DTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyExample4902DTO_.customFieldPercent, entity::setCustomFieldPercent);
        if (data.isFieldChanged(MyExample4902DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity4902Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample4902DTO_.customFieldInlineId)) {
            entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
                    ? entityManager.getReference(MyEntity4902PickInline.class, data.getCustomFieldInlineId())
                    : null);
        }
        setIfChanged(data, MyExample4902DTO_.customFieldMoney, entity::setCustomFieldMoney);
        setIfChanged(data, MyExample4902DTO_.customFieldRadio, entity::setCustomFieldRadio);
        if (data.isFieldChanged(MyExample4902DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample4902DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity4902Multi.class, e))
                    .collect(Collectors.toList()));
        }
        setIfChanged(data, MyExample4902DTO_.customFieldHint, entity::setCustomFieldHint);
        if (data.isFieldChanged(MyExample4902DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity4902MultiHover.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample4902DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample4902DTO> getActions() {
        return Actions.<MyExample4902DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }

}