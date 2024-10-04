package org.demo.documentation.widgets.additionalinfo.base;

import jakarta.persistence.EntityManager;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.widgets.additionalinfo.base.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Multi2;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Pick;
import org.demo.documentation.widgets.additionalinfo.base.forfields.MyEntity3600Pick2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;


@Service
public class MyExample3600Service extends VersionAwareResponseService<MyExample3600DTO, MyEntity3600> {

    private final MyEntity3600Repository repository;
    @Autowired
    private EntityManager entityManager;

    public MyExample3600Service(MyEntity3600Repository repository) {
        super(MyExample3600DTO.class, MyEntity3600.class, null, MyExample3600Meta.class);
        this.repository = repository;
    }

    @Override
    protected CreateResult<MyExample3600DTO> doCreateEntity(MyEntity3600 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3600DTO> doUpdateEntity(MyEntity3600 entity, MyExample3600DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample3600DTO_.customFieldDate)) {
            entity.setCustomFieldDate(data.getCustomFieldDate());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3600Multi.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldHint)) {
            entity.setCustomFieldHint(data.getCustomFieldHint());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3600Multi2.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldMultipleSelect)) {
            entity.setCustomFieldMultipleSelect(
                    data.getCustomFieldMultipleSelect().getValues()
                            .stream()
                            .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldPickListId)) {
            entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                    ? entityManager.getReference(MyEntity3600Pick2.class, data.getCustomFieldPickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldInlinePickListId)) {
            entity.setCustomFieldInlinePickListEntity(data.getCustomFieldInlinePickListId() != null
                    ? entityManager.getReference(MyEntity3600Pick.class, data.getCustomFieldInlinePickListId())
                    : null);
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldDateTimeWithSeconds)) {
            entity.setCustomFieldDateTimeWithSeconds(data.getCustomFieldDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldRadio)) {
            entity.setCustomFieldRadio(data.getCustomFieldRadio());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldMoney)) {
            entity.setCustomFieldMoney(data.getCustomFieldMoney());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldPercent)) {
            entity.setCustomFieldPercent(data.getCustomFieldPercent());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldNum)) {
            entity.setCustomFieldNum(data.getCustomFieldNum());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldCheckbox)) {
            entity.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldDateTime)) {
            entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customFieldText)) {
            entity.setCustomFieldText(data.getCustomFieldText());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customField3)) {
            entity.setCustomField3(data.getCustomField3());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customField2)) {
            entity.setCustomField2(data.getCustomField2());
        }
        if (data.isFieldChanged(MyExample3600DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3600DTO> getActions() {
        return Actions.<MyExample3600DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}