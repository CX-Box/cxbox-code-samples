package org.demo.documentation.other.alltypes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.multivalue.MultivalueFieldSingleValue;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.other.alltypes.enums.MultipleTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import java.util.Objects;
import java.util.stream.Collectors;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample421Service extends VersionAwareResponseService<MyExample421DTO, MyEntity421> {

    private final MyEntity421Repository repository;
    @Getter(onMethod_ = @Override)
    private final Class<MyExample421Meta> meta = MyExample421Meta.class;
    @Autowired
    private EntityManager entityManager;

    @Override
    protected CreateResult<MyExample421DTO> doCreateEntity(MyEntity421 entity, BusinessComponent bc) {
        repository.save(entity);
        return new CreateResult<>(entityToDto(bc, entity));
    }

    @Override
    protected ActionResultDTO<MyExample421DTO> doUpdateEntity(MyEntity421 entity, MyExample421DTO data, BusinessComponent bc) {
        if (data.isFieldChanged(MyExample421DTO_.multihoverType)) {
            entity.getMultihoverTypeList().clear();
            entity.getMultihoverTypeList().addAll(data.getMultihoverType().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity424.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample421DTO_.hintType)) {
            entity.setHintType(data.getHintType());
        }
        if (data.isFieldChanged(MyExample421DTO_.multivalueType)) {
            entity.getMultivalueTypeList().clear();
            entity.getMultivalueTypeList().addAll(data.getMultivalueType().getValues().stream()
                    .map(MultivalueFieldSingleValue::getId)
                    .filter(Objects::nonNull)
                    .map(Long::parseLong)
                    .map(e -> entityManager.getReference(MyEntity422.class, e))
                    .toList());
        }
        if (data.isFieldChanged(MyExample421DTO_.multipleType)) {
            entity.setMultipleType(
                    data.getMultipleType().getValues()
                            .stream()
                            .map(v -> MultipleTypeEnum.getByValue(v.getValue()))
                            .collect(Collectors.toSet()));
        }
        if (data.isFieldChanged(MyExample421DTO_.inlinepicklistTypeId)) {
            entity.setInlinepicklistTypeEntity(data.getInlinepicklistTypeId() != null
                    ? entityManager.getReference(MyEntity423.class, data.getInlinepicklistTypeId())
                    : null);
        }
        if (data.isFieldChanged(MyExample421DTO_.picklistTypeId)) {
            entity.setPicklistTypeEntity(data.getPicklistTypeId() != null
                    ? entityManager.getReference(MyEntity422.class, data.getPicklistTypeId())
                    : null);
        }

        if (data.isFieldChanged(MyExample421DTO_.radioType)) {
            entity.setRadioType(data.getRadioType());
        }
        if (data.isFieldChanged(MyExample421DTO_.moneyType)) {
            entity.setMoneyType(data.getMoneyType());
        }
        if (data.isFieldChanged(MyExample421DTO_.percentTypeDouble)) {
            entity.setPercentTypeDouble(data.getPercentTypeDouble());
        }
        if (data.isFieldChanged(MyExample421DTO_.percentType)) {
            entity.setPercentType(data.getPercentType());
        }
        if (data.isFieldChanged(MyExample421DTO_.numberTypeDouble)) {
            entity.setNumberTypeDouble(data.getNumberTypeDouble());
        }
        if (data.isFieldChanged(MyExample421DTO_.numberType)) {
            entity.setNumberType(data.getNumberType());
        }
        if (data.isFieldChanged(MyExample421DTO_.fileUploadTypeId)) {
            entity.setFileUploadTypeId(data.getFileUploadTypeId());
        }
        if (data.isFieldChanged(MyExample421DTO_.fileUploadType)) {
            entity.setFileUploadType(data.getFileUploadType());
        }
        if (data.isFieldChanged(MyExample421DTO_.dictionaryType)) {
            entity.setDictionaryType(data.getDictionaryType());
        }
        if (data.isFieldChanged(MyExample421DTO_.dateTimeWithSecondsType)) {
            entity.setDateTimeWithSecondsType(data.getDateTimeWithSecondsType());
        }
        if (data.isFieldChanged(MyExample421DTO_.dateType)) {
            entity.setDateType(data.getDateType());
        }
        if (data.isFieldChanged(MyExample421DTO_.checkboxType)) {
            entity.setCheckboxType(data.getCheckboxType());
        }
        if (data.isFieldChanged(MyExample421DTO_.dateTimeType)) {
            entity.setDateTimeType(data.getDateTimeType());
        }
        if (data.isFieldChanged(MyExample421DTO_.textType)) {
            entity.setTextType(data.getTextType());
        }
        if (data.isFieldChanged(MyExample421DTO_.hiddenType)) {
            entity.setHiddenType(data.getHiddenType());
        }
        if (data.isFieldChanged(MyExample421DTO_.inputField)) {
            entity.setInputField(data.getInputField());
        }

        return new ActionResultDTO<>(entityToDto(bc, entity));
    }

     // --8<-- [start:getActions]
    @Override
    public Actions<MyExample421DTO> getActions() {
        return Actions.<MyExample421DTO>builder()
                .action(act -> act
                        .action("save", "save")
                )
                .build();
    }
     // --8<-- [end:getActions]  
}