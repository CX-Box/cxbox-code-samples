package org.demo.documentation.widgets.additionalinfo.colortitle;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorRadioEnum;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3025DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldColorInput", provider = StringValueProvider.class)
    private String customFieldColorInput;
    @SearchParameter(name = "customFieldColorText", provider = StringValueProvider.class)
    private String customFieldColorText;
    @SearchParameter(name = "customFieldColorDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldColorDateTime;
    @SearchParameter(name = "customFieldColorCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldColorCheckbox;
    @SearchParameter(name = "customFieldColorDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldColorDate;
    @SearchParameter(name = "customFieldColorDateTimeWithSeconds", provider = DateValueProvider.class)
    private LocalDateTime customFieldColorDateTimeWithSeconds;
    @SearchParameter(name = "customFieldColorDictionary", provider = EnumValueProvider.class)
    private CustomFieldColorDictionaryEnum customFieldColorDictionary;
    @SearchParameter(name = "customFieldColorFileUploade", provider = StringValueProvider.class)
    private String customFieldColorFileUploade;
    private String customFieldColorFileUploadeId;
    @SearchParameter(name = "customFieldColorNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldColorNumber;
    @SearchParameter(name = "customFieldColorPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldColorPercent;
    @SearchParameter(name = "customFieldColorMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldColorMoney;
    @SearchParameter(name = "customFieldColorRadio", provider = EnumValueProvider.class)
    private CustomFieldColorRadioEnum customFieldColorRadio;
    @SearchParameter(name = "customFieldColorPicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldColorPicklist;
    @SearchParameter(name = "customFieldColorPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldColorPicklistId;
    @SearchParameter(name = "customFieldColorInlinePicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldColorInlinePicklist;
    @SearchParameter(name = "customFieldColorInlinePicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldColorInlinePicklistId;

    public MyExample3025DTO(MyEntity3025 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldColorInput = entity.getCustomFieldColorInput();
        this.customFieldColorText = entity.getCustomFieldColorText();
        this.customFieldColorDateTime = entity.getCustomFieldColorDateTime();
        this.customFieldColorCheckbox = entity.getCustomFieldColorCheckbox();
        this.customFieldColorDate = entity.getCustomFieldColorDate();
        this.customFieldColorDateTimeWithSeconds = entity.getCustomFieldColorDateTimeWithSeconds();
        this.customFieldColorDictionary = entity.getCustomFieldColorDictionary();
        this.customFieldColorFileUploade = entity.getCustomFieldColorFileUploade();
        this.customFieldColorFileUploadeId = entity.getCustomFieldColorFileUploadeId();
        this.customFieldColorNumber = entity.getCustomFieldColorNumber();
        this.customFieldColorPercent = entity.getCustomFieldColorPercent();
        this.customFieldColorMoney = entity.getCustomFieldColorMoney();
        this.customFieldColorRadio = entity.getCustomFieldColorRadio();
        this.customFieldColorPicklistId = Optional.ofNullable(entity.getCustomFieldColorPicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldColorPicklist = Optional.ofNullable(entity.getCustomFieldColorPicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldColorInlinePicklistId = Optional.ofNullable(entity.getCustomFieldColorInlinePicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldColorInlinePicklist = Optional.ofNullable(entity.getCustomFieldColorInlinePicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
    }
}