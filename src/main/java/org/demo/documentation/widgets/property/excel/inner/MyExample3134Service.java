package org.demo.documentation.widgets.property.excel.inner;

import jakarta.persistence.EntityManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;

import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134InlinePick;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134Multi;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134MultiHover;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134Pick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample3134Service extends VersionAwareResponseService<MyExample3134DTO, MyEntity3134> {

    private final MyEntity3134Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample3134Meta> meta = MyExample3134Meta.class;
    @Autowired
  private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample3134DTO> doCreateEntity(MyEntity3134 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample3134DTO> doUpdateEntity(MyEntity3134 entity, MyExample3134DTO data, BusinessComponent bc) {
      setIfChanged(data, MyExample3134DTO_.customFieldMoneyWithCurrencyDynamic, entity::setCustomFieldMoneyWithCurrencyDynamic);
      setIfChanged(data, MyExample3134DTO_.customFieldMoneyWithCurrencyConst, entity::setCustomFieldMoneyWithCurrencyConst);
      setIfChanged(data, MyExample3134DTO_.customFieldHidden, entity::setCustomFieldHidden);
      setIfChanged(data, MyExample3134DTO_.customFieldText, entity::setCustomFieldText);
      setIfChanged(data, MyExample3134DTO_.customFieldDateTime, entity::setCustomFieldDateTime);
      setIfChanged(data, MyExample3134DTO_.customFieldCheckbox, entity::setCustomFieldCheckbox);
      setIfChanged(data, MyExample3134DTO_.customFieldDate, entity::setCustomFieldDate);
      setIfChanged(data, MyExample3134DTO_.customFieldDateTimeWithSeconds, entity::setCustomFieldDateTimeWithSeconds);
      setIfChanged(data, MyExample3134DTO_.customFieldDictionary, entity::setCustomFieldDictionary);
      setIfChanged(data, MyExample3134DTO_.customFieldFileUploadId, entity::setCustomFieldFileUploadId);
      setIfChanged(data, MyExample3134DTO_.customFieldFileUpload, entity::setCustomFieldFileUpload);
      setIfChanged(data, MyExample3134DTO_.customFieldNumber, entity::setCustomFieldNumber);
      setIfChanged(data, MyExample3134DTO_.customFieldPercent, entity::setCustomFieldPercent);
      if (data.isFieldChanged(MyExample3134DTO_.customFieldPickListId)) {
        entity.setCustomFieldPickListEntity(data.getCustomFieldPickListId() != null
                ? entityManager.getReference(MyEntity3134Pick.class, data.getCustomFieldPickListId())
                : null);
      }
      if (data.isFieldChanged(MyExample3134DTO_.customFieldInlineId)) {
        entity.setCustomFieldInlineEntity(data.getCustomFieldInlineId() != null
                ? entityManager.getReference(MyEntity3134InlinePick.class, data.getCustomFieldInlineId())
                : null);
      }
      setIfChanged(data, MyExample3134DTO_.customFieldMoney, entity::setCustomFieldMoney);
      setIfChanged(data, MyExample3134DTO_.customFieldRadio, entity::setCustomFieldRadio);
      if (data.isFieldChanged(MyExample3134DTO_.customFieldMultipleSelect)) {
        entity.setCustomFieldMultipleSelect(
                data.getCustomFieldMultipleSelect().getValues()
                        .stream()
                        .map(v -> CustomFieldMultipleSelectEnum.getByValue(v.getValue()))
                        .collect(Collectors.toSet()));
      }
      if (data.isFieldChanged(MyExample3134DTO_.customFieldMultivalue)) {
        entity.getCustomFieldMultivalueList().clear();
        entity.getCustomFieldMultivalueList().addAll(data.getCustomFieldMultivalue().getValues().stream()
                .map(MultivalueFieldSingleValue::getId)
                .filter(Objects::nonNull)
                .map(Long::parseLong)
                .map(e -> entityManager.getReference(MyEntity3134Multi.class, e))
                .toList());
      }
      setIfChanged(data, MyExample3134DTO_.customFieldHint, entity::setCustomFieldHint);
      if (data.isFieldChanged(MyExample3134DTO_.customFieldMultivalueHover)) {
        entity.getCustomFieldMultivalueHoverList().clear();
        entity.getCustomFieldMultivalueHoverList().addAll(data.getCustomFieldMultivalueHover().getValues().stream()
                .map(MultivalueFieldSingleValue::getId)
                .filter(Objects::nonNull)
                .map(Long::parseLong)
                .map(e -> entityManager.getReference(MyEntity3134MultiHover.class, e))
                .toList());
      }
      if (data.isFieldChanged(MyExample3134DTO_.customField)) {
            entity.setCustomField(data.getCustomField());
        }
        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

  // --8<-- [start:getActions]
    @Override
    public Actions<MyExample3134DTO> getActions() {
        return Actions.<MyExample3134DTO>builder()
               .save(sv -> sv.text("Save"))
                .create(crt -> crt)
                .delete(dlt -> dlt)
                .build();
    }
  // --8<-- [end:getActions]
}
