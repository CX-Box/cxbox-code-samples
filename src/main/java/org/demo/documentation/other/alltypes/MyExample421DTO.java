package org.demo.documentation.other.alltypes;

import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.other.alltypes.enums.DictionaryTypeEnum;
import org.demo.documentation.other.alltypes.enums.MultipleTypeEnum;
import org.demo.documentation.other.alltypes.enums.RadioTypeEnum;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample421DTO extends DataResponseDTO {

    @SearchParameter(name = "inputField")
    private String inputField;
    private String hiddenType;
    @SearchParameter(name = "textType")
    private String textType;
    @SearchParameter(name = "dateTimeType", provider = DateTimeValueProvider.class)
    private LocalDateTime dateTimeType;
    @SearchParameter(name = "checkboxType", provider = BooleanValueProvider.class)
    private Boolean checkboxType;
    @SearchParameter(name = "dateType", provider = DateValueProvider.class)
    private LocalDateTime dateType;
    @SearchParameter(name = "dateTimeWithSecondsType", provider = DateValueProvider.class)
    private LocalDateTime dateTimeWithSecondsType;
    @SearchParameter(name = "dictionaryType", provider = EnumValueProvider.class)
    private DictionaryTypeEnum dictionaryType;
    @SearchParameter(name = "fileUploadType")
    private String fileUploadType;
    private String fileUploadTypeId;
    @SearchParameter(name = "numberType", provider = BigDecimalValueProvider.class)
    private Long numberType;
    @SearchParameter(name = "numberTypeDouble", provider = BigDecimalValueProvider.class)
    private Double numberTypeDouble;
    @SearchParameter(name = "percentType", provider = BigDecimalValueProvider.class)
    private Long percentType;
    @SearchParameter(name = "percentTypeDouble", provider = BigDecimalValueProvider.class)
    private Double percentTypeDouble;
    @SearchParameter(name = "moneyType", provider = BigDecimalValueProvider.class)
    private Double moneyType;
    @SearchParameter(name = "radioType", provider = EnumValueProvider.class)
    private RadioTypeEnum radioType;
    @SearchParameter(name = "picklistTypeEntity.customField")
    private String picklistType;
    @SearchParameter(name = "picklistTypeEntity.id", provider = LongValueProvider.class)
    private Long picklistTypeId;
    @SearchParameter(name = "inlinepicklistTypeEntity.customField")
    private String inlinepicklistType;
    @SearchParameter(name = "inlinepicklistTypeEntity.id", provider = LongValueProvider.class)
    private Long inlinepicklistTypeId;
    @SearchParameter(name = "multipleType", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
    @EnumValueProvider.BaseEnum(value = MultipleTypeEnum.class)
    private MultivalueField multipleType;
    @SearchParameter(name = "multivalueType.id", provider = LongValueProvider.class)
    private MultivalueField multivalueType;
    private String multivalueTypeDisplayedKey;
    private String hintType;
    @SearchParameter(name = "multihoverType.id", provider = LongValueProvider.class)
    private MultivalueField multihoverType;
    private String multihoverTypeDisplayedKey;


    public MyExample421DTO(MyEntity421 entity) {
        this.id = entity.getId().toString();
        this.inputField = entity.getInputField();
        this.hiddenType = entity.getHiddenType();
        this.textType = entity.getTextType();
        this.dateTimeType = entity.getDateTimeType();
        this.checkboxType = entity.getCheckboxType();
        this.dateType = entity.getDateType();
        this.dateTimeWithSecondsType = entity.getDateTimeWithSecondsType();
        this.dictionaryType = entity.getDictionaryType();
        this.fileUploadType = entity.getFileUploadType();
        this.fileUploadTypeId = entity.getFileUploadTypeId();
        this.numberType = entity.getNumberType();
        this.numberTypeDouble = entity.getNumberTypeDouble();
        this.percentType = entity.getPercentType();
        this.percentTypeDouble = entity.getPercentTypeDouble();
        this.moneyType = entity.getMoneyType();
        this.radioType = entity.getRadioType();

        this.picklistTypeId = Optional.ofNullable(entity.getPicklistTypeEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.picklistType = Optional.ofNullable(entity.getPicklistTypeEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.inlinepicklistTypeId = Optional.ofNullable(entity.getInlinepicklistTypeEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.inlinepicklistType = Optional.ofNullable(entity.getInlinepicklistTypeEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.multipleType = entity.getMultipleType().stream().collect(MultivalueField.toMultivalueField(Enum::name, MultipleTypeEnum::getValue));
        this.multivalueType = entity.getMultivalueTypeList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity422::getCustomField
        ));
        this.multivalueTypeDisplayedKey = StringUtils.abbreviate(entity.getMultivalueTypeList().stream().map(MyEntity422::getCustomField
        ).collect(Collectors.joining(",")), 12);
        this.hintType = entity.getHintType();
        this.multihoverType = entity.getMultihoverTypeList().stream().collect(MultivalueField.toMultivalueField(
                e -> String.valueOf(e.getId()),
                MyEntity424::getCustomField
        ));
        this.multihoverTypeDisplayedKey = StringUtils.abbreviate(entity.getMultihoverTypeList().stream().map(MyEntity424::getCustomField
        ).collect(Collectors.joining(",")), 12);
    }
}