package org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.picklist;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067MultiMulti;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067PickInlinePicklist;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067PickPicklist;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067Pick;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.MyEntity3067PickRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

import java.util.Objects;

@Getter
@Service
public class MyEntity3067PickPick0Service extends VersionAwareResponseService<MyEntity3067PickPick0DTO, MyEntity3067Pick> {

    MyEntity3067PickRepository repository;

    @Autowired
    private EntityManager entityManager;

    public MyEntity3067PickPick0Service() {
        super(MyEntity3067PickPick0DTO.class, MyEntity3067Pick.class, null, MyEntity3067PickPick0Meta.class);
    }

    @Override
    protected CreateResult<MyEntity3067PickPick0DTO> doCreateEntity(MyEntity3067Pick entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyEntity3067PickPick0DTO> doUpdateEntity(MyEntity3067Pick entity, MyEntity3067PickPick0DTO data,
                                                                       BusinessComponent bc) {
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldInput)) {
            entity.setCustomFieldInput(data.getCustomFieldInput());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldText)) {
            entity.setCustomFieldText(data.getCustomFieldText());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldDateTime)) {
            entity.setCustomFieldDateTime(data.getCustomFieldDateTime());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldCheckbox)) {
            entity.setCustomFieldCheckbox(data.getCustomFieldCheckbox());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldDate)) {
            entity.setCustomFieldDate(data.getCustomFieldDate());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldDateTimeWithSeconds)) {
            entity.setCustomFieldDateTimeWithSeconds(data.getCustomFieldDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldDictionary)) {
            entity.setCustomFieldDictionary(data.getCustomFieldDictionary());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldFileUploadeId)) {
            entity.setCustomFieldFileUploadeId(data.getCustomFieldFileUploadeId());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldFileUploade)) {
            entity.setCustomFieldFileUploade(data.getCustomFieldFileUploade());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldNumber)) {
            entity.setCustomFieldNumber(data.getCustomFieldNumber());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldPercent)) {
            entity.setCustomFieldPercent(data.getCustomFieldPercent());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldMoney)) {
            entity.setCustomFieldMoney(data.getCustomFieldMoney());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldRadio)) {
            entity.setCustomFieldRadio(data.getCustomFieldRadio());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldPicklistId)) {
            entity.setCustomFieldPicklistEntity(data.getCustomFieldPicklistId() != null
                    ? entityManager.getReference(MyEntity3067PickPicklist.class, data.getCustomFieldPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldInlinePicklistId)) {
            entity.setCustomFieldInlinePicklistEntity(data.getCustomFieldInlinePicklistId() != null
                    ? entityManager.getReference(MyEntity3067PickInlinePicklist.class, data.getCustomFieldInlinePicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldMultivalue)) {
            entity.getCustomFieldMultivalueList().clear();
            entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3067Multi.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyEntity3067PickPick0DTO_.customFieldMultivalueHover)) {
            entity.getCustomFieldMultivalueHoverList().clear();
            entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3067MultiMulti.class, e))
                    .toList());
        }
        repository.save(entity);
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}