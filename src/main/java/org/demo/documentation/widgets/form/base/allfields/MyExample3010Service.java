package org.demo.documentation.widgets.form.base.allfields;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Multi;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010MultiHover;
import org.demo.documentation.widgets.form.base.allfields.forfields.MyEntity3010Pick;
import org.demo.documentation.widgets.form.base.allfields.forfields.enums.CustomFieldMultipleSelectEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3010Service extends VersionAwareResponseService<MyExample3010DTO, MyEntity3010> {

    private final MyEntity3010Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3010Service(MyEntity3010Repository repository) {
        super(MyExample3010DTO.class, MyEntity3010.class, null, MyExample3010Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3010DTO> doCreateEntity(MyEntity3010 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3010DTO> doUpdateEntity(MyEntity3010 entity, MyExample3010DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3010DTO_.customFieldHidden, entity::setCustomFieldHidden);
        setIfChanged(data, MyExample3010DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample3010DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
        setIfChanged(data, MyExample3010DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        setIfChanged(data, MyExample3010DTO_.customFieldDate, entity::setCustomFieldDate);
        setIfChanged(data, MyExample3010DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
        setIfChanged(data, MyExample3010DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        setIfChanged(data, MyExample3010DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
        setIfChanged(data, MyExample3010DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
        setIfChanged(data, MyExample3010DTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyExample3010DTO_.customFieldPercent, entity::setCustomFieldPercent);
        if (data.isFieldChanged(MyExample3010DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3010Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3010DTO_.customFieldInlineId)) {
            entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
                    ? entityManager.getReference(MyEntity3010Pick.class, data.getCustomFieldInlineId())
                    : null);
        }
        setIfChanged(data, MyExample3010DTO_.customFieldMoney, entity::setCustomFieldMoney);
        setIfChanged(data, MyExample3010DTO_.customFieldRadio, entity::setCustomFieldRadio);
        if (data.isFieldChanged(MyExample3010DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample3010DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3010Multi.class, e))
                    .collect(Collectors.toList()));
        }
        setIfChanged(data, MyExample3010DTO_.customFieldHint, entity::setCustomFieldHint);
        if (data.isFieldChanged(MyExample3010DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3010MultiHover.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3010DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3010DTO> getActions() {
        return Actions.<MyExample3010DTO>builder()
                .save(sv -> sv.text("Save"))
                .build();
    }


}

