package org.demo.documentation.widgets.picklist.colortitle;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061Multi;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061MultiMulti;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061Pick;
import org.demo.documentation.widgets.picklist.colortitle.forfields.MyEntity3061PickPick;
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
public class MyEntity3061PickService extends VersionAwareResponseService<MyEntity3061PickDTO, MyEntity3061> {

    @Autowired
    private EntityManager entityManager;

    public MyEntity3061PickService() {
        super(MyEntity3061PickDTO.class, MyEntity3061.class, null, MyEntity3061PickMeta.class);
    }

    @Override
    protected CreateResult<MyEntity3061PickDTO> doCreateEntity(MyEntity3061 entity, BusinessComponent bc) {
        return null;
    }

    @Override
    protected ActionResultDTO<MyEntity3061PickDTO> doUpdateEntity(MyEntity3061 entity, MyEntity3061PickDTO data,
                                                                  BusinessComponent bc) {
        setIfChanged(data, MyEntity3061PickDTO_.customFieldColorText, entity::setCustomFieldColorText);
        setIfChanged(data, MyEntity3061PickDTO_.customFieldColorInput, entity::setCustomFieldColorInput);
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorDateTime)) {
            entity.setCustomFieldColorDateTime(data.getCustomFieldColorDateTime());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorCheckbox)) {
            entity.setCustomFieldColorCheckbox(data.getCustomFieldColorCheckbox());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorDate)) {
            entity.setCustomFieldColorDate(data.getCustomFieldColorDate());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorDateTimeWithSeconds)) {
            entity.setCustomFieldColorDateTimeWithSeconds(data.getCustomFieldColorDateTimeWithSeconds());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorDictionary)) {
            entity.setCustomFieldColorDictionary(data.getCustomFieldColorDictionary());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorFileUploadeId)) {
            entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorFileUploade)) {
            entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorFileUploadeId)) {
            entity.setCustomFieldColorFileUploadeId(data.getCustomFieldColorFileUploadeId());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorFileUploade)) {
            entity.setCustomFieldColorFileUploade(data.getCustomFieldColorFileUploade());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorNumber)) {
            entity.setCustomFieldColorNumber(data.getCustomFieldColorNumber());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorPercent)) {
            entity.setCustomFieldColorPercent(data.getCustomFieldColorPercent());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorMoney)) {
            entity.setCustomFieldColorMoney(data.getCustomFieldColorMoney());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorRadio)) {
            entity.setCustomFieldColorRadio(data.getCustomFieldColorRadio());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorPicklistId)) {
            entity.setCustomFieldColorPicklistEntity(data.getCustomFieldColorPicklistId() != null
                    ? entityManager.getReference(MyEntity3061PickPick.class, data.getCustomFieldColorPicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorInlinePicklistId)) {
            entity.setCustomFieldColorInlinePicklistEntity(data.getCustomFieldColorInlinePicklistId() != null
                    ? entityManager.getReference(MyEntity3061Pick.class, data.getCustomFieldColorInlinePicklistId())
                    : null);
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorMultivalue)) {
            entity.getCustomFieldColorMultivalueList().clear();
            entity.getCustomFieldColorMultivalueList().addAll(data.getCustomFieldColorMultivalue().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3061MultiMulti.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyEntity3061PickDTO_.customFieldColorMultivalueHover)) {
            entity.getCustomFieldColorMultivalueHoverList().clear();
            entity.getCustomFieldColorMultivalueHoverList().addAll(data.getCustomFieldColorMultivalueHover().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity3061Multi.class, e))
                    .toList());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }


}