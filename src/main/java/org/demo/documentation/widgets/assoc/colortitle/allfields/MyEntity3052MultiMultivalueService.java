package org.demo.documentation.widgets.assoc.colortitle.allfields;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;

import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052MultiAssoc;
import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052MultiMultiAssoc;
import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052Picklist;
import org.demo.documentation.widgets.assoc.colortitle.allfields.forfields.MyEntity3052PicklistAssoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;

import java.util.Objects;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3052MultiMultivalueService extends VersionAwareResponseService<MyEntity3052MultiMultivalueDTO, MyEntity3052Multi> {

    @Getter(onMethod_ = @Override)
    private final Class<MyEntity3052MultiMultivalueMeta> meta = MyEntity3052MultiMultivalueMeta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyEntity3052MultiMultivalueDTO> doCreateEntity(MyEntity3052Multi entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3052MultiMultivalueDTO> doUpdateEntity(MyEntity3052Multi entity, MyEntity3052MultiMultivalueDTO data,
                                                                             BusinessComponent bc) {
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorInput)) {
            entity.setCustomFieldColorInput(data.getCustomFieldColorInput());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorText)) {
            entity.setCustomFieldColorText(data.getCustomFieldColorText());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorDateTime)) {
            entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorCheckbox)) {
            entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorDate)) {
            entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorDateTimeWithSeconds)) {
            entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorDictionary)) {
            entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorFileUploadeId)) {
            entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorFileUploade)) {
            entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorNumber)) {
            entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorPercent)) {
            entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorMoney)) {
            entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorRadio)) {
            entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorPicklistId)) {
            entity.setCustomFieldColorPicklistEntity(data.getCustomFieldColorPicklistId() != null
                    ? entityManager.getReference(MyEntity3052PicklistAssoc.class, data.getCustomFieldColorPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorInlinePicklistId)) {
            entity.setCustomFieldColorInlinePicklistEntity(data.getCustomFieldColorInlinePicklistId() != null
                    ? entityManager.getReference(MyEntity3052Picklist.class, data.getCustomFieldColorInlinePicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorMultivalue)) {
            entity.getCustomFieldColorMultivalueList().clear();
            entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3052MultiMultiAssoc.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyEntity3052MultiMultivalueDTO_.customFieldColorMultivalueHover)) {
            entity.getCustomFieldColorMultivalueHoverList().clear();
            entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3052MultiAssoc.class, e))
                    .toList());
        }
        return null;
    }


}