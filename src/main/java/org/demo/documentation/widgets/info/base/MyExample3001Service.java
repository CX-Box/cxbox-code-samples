package org.demo.documentation.widgets.info.base;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.demo.documentation.widgets.info.base.forfields.MyEntity4222Multi;
import org.demo.documentation.widgets.info.base.forfields.MyEntity4222Multi2;
import org.demo.documentation.widgets.info.base.forfields.MyEntity4222Pick;
import org.demo.documentation.widgets.info.base.forfields.MyEntity4222Pick2;
import org.demo.documentation.widgets.info.base.enums.CustomFieldMultipleSelectEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class MyExample3001Service extends VersionAwareResponseService<MyExample3001DTO, MyEntity3001> {

    private final MyEntity3001Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3001Service(MyEntity3001Repository repository) {
        super(MyExample3001DTO.class, MyEntity3001.class, null, MyExample3001Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3001DTO> doCreateEntity(MyEntity3001 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    // --8<-- [start:doUpdateEntity]
    @Override
    protected ActionResultDTO<MyExample3001DTO> doUpdateEntity(MyEntity3001 entity, MyExample3001DTO data,
                                                               BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3001DTO_.customFieldInlinePickListId)) {
            entity.setCustomFieldInlinePickListEntity(data.getCustomFieldInlinePickListId() != null
                    ? entityManager.getReference(MyEntity4222Pick2.class, data.getCustomFieldInlinePickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity4222Pick.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity4222Multi2.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity4222Multi.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldText)) {
            entity.setCustomFieldText(data.getCustomFieldText());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldDateTime)) {
            entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldCheckbox)) {
            entity.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldNum)) {
            entity.setCustomFieldNum(data.getCustomFieldNum());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldMoney)) {
            entity.setCustomFieldMoney(data.getCustomFieldMoney());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldRadio)) {
            entity.setCustomFieldRadio(data.getCustomFieldRadio());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldDateTimeWithSeconds)) {
            entity.setCustomFieldDateTimeWithSeconds(data.getCustomFieldDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldPercent)) {
            entity.setCustomFieldPercent(data.getCustomFieldPercent());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldHint)) {
            entity.setCustomFieldHint(data.getCustomFieldHint());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customFieldDate)) {
            entity.setCustomFieldDate(data.getCustomFieldDate());
        }
        if (data.isFieldChanged(MyExample3001DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }
    // --8<-- [end:doUpdateEntity]

    // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3001DTO> getActions() {
        return Actions.<MyExample3001DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
    // --8<-- [end:getActions]

}