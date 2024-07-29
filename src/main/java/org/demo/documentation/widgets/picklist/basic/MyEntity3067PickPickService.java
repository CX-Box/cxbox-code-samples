package org.demo.documentation.widgets.picklist.basic;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067Multi;
import org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067MultiMulti;
import org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067PickInlinePicklist;
import org.demo.documentation.widgets.picklist.basic.forfields.MyEntity3067PickPicklist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

import java.util.Objects;
import java.util.stream.Collectors;


@Getter
@Service
public class MyEntity3067PickPickService extends VersionAwareResponseService<MyEntity3067PickPickDTO, MyEntity3067Pick> {

    @Autowired
    private EntityManager entityManager;

    public MyEntity3067PickPickService() {
        super(MyEntity3067PickPickDTO.class, MyEntity3067Pick.class, null, MyEntity3067PickPickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3067PickPickDTO> doCreateEntity(MyEntity3067Pick entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3067PickPickDTO> doUpdateEntity(MyEntity3067Pick entity, MyEntity3067PickPickDTO data,
                                                                      BusinessComponent bc) {
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldInput)) {
            entity.setCustomFieldInput(data.getCustomFieldInput());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldText)) {
            entity.setCustomFieldText(data.getCustomFieldText());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldDateTime)) {
            entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldCheckbox)) {
            entity.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldDate)) {
            entity.setCustomFieldDate(data.getCustomFieldDate());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldDateTimeWithSeconds)) {
            entity.setCustomFieldDateTimeWithSeconds(data.getCustomFieldDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldFileUploadeId)) {
            entity.setCustomFieldFileUploadeId(data.getCustomFieldFileUploadeId());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldFileUploade)) {
            entity.setCustomFieldFileUploade(data.getCustomFieldFileUploade());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldNumber)) {
            entity.setCustomFieldNumber(data.getCustomFieldNumber());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldPercent)) {
            entity.setCustomFieldPercent(data.getCustomFieldPercent());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldMoney)) {
            entity.setCustomFieldMoney(data.getCustomFieldMoney());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldRadio)) {
            entity.setCustomFieldRadio(data.getCustomFieldRadio());
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldPicklistId)) {
            entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
                    ? entityManager.getReference(MyEntity3067PickPicklist.class, data.getCustomFieldPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldInlinePicklistId)) {
            entity.setCustomFieldInlinePicklistEntity(data.getCustomFieldInlinePicklistId() != null
                    ? entityManager.getReference(MyEntity3067PickInlinePicklist.class, data.getCustomFieldInlinePicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3067Multi.class, e))
                    .collect(Collectors.toList()));
        }
        if (data.isFieldChanged(MyEntity3067PickPickDTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3067MultiMulti.class, e))
                    .collect(Collectors.toList()));
        }
        return null;
    }


}