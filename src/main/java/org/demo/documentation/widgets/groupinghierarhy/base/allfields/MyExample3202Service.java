package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.groupinghierarhy.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MyExample3202Service extends VersionAwareResponseService<MyExample3202DTO, MyEntity3202> {

    private final MyEntity3202Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3202Service(MyEntity3202Repository repository) {
        super(MyExample3202DTO.class, MyEntity3202.class, null, MyExample3202Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3202DTO> doCreateEntity(MyEntity3202 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3202DTO> doUpdateEntity(MyEntity3202 entity, MyExample3202DTO data, BusinessComponent bc) {
        setIfChanged(data, MyExample3202DTO_.customFieldHidden, entity::setCustomFieldHidden);
        setIfChanged(data, MyExample3202DTO_.customFieldText, entity::setCustomFieldText);
        setIfChanged(data, MyExample3202DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
        setIfChanged(data, MyExample3202DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
        setIfChanged(data, MyExample3202DTO_.customFieldDate, entity::setCustomFieldDate);
        setIfChanged(data, MyExample3202DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
        setIfChanged(data, MyExample3202DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
        setIfChanged(data, MyExample3202DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
        setIfChanged(data, MyExample3202DTO_.customFieldNumber, entity::setCustomFieldNumber);
        setIfChanged(data, MyExample3202DTO_.customFieldPercent, entity::setCustomFieldPercent);
        if (data.isFieldChanged(MyExample3202DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3202Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3202DTO_.customFieldInlineId)) {
            entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
                    ? entityManager.getReference(MyEntity3202Pick.class, data.getCustomFieldInlineId())
                    : null);
        }
        setIfChanged(data, MyExample3202DTO_.customFieldMoney, entity::setCustomFieldMoney);
        setIfChanged(data, MyExample3202DTO_.customFieldRadio, entity::setCustomFieldRadio);
        if (data.isFieldChanged(MyExample3202DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample3202DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3202Multi.class, e))
                    .toList());
        }
        setIfChanged(data, MyExample3202DTO_.customFieldHint, entity::setCustomFieldHint);
        if (data.isFieldChanged(MyExample3202DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3202MultiHover.class, e))
                    .toList());
        }
        setIfChanged(data, MyExample3202DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
        if (data.isFieldChanged(MyExample3202DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

    @Override
    public Actions<MyExample3202DTO> getActions() {
        return Actions.<MyExample3202DTO>builder()
                .create(crt -> crt.text("Add"))
                .save(sv -> sv.text("Save"))
                .cancelCreate(ccr -> ccr.text("Cancel").available(bc -> true))
                .delete(dlt -> dlt.text("Delete"))
                .build();
    }


}

