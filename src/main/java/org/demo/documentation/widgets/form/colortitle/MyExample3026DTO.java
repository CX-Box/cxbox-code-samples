package org.demo.documentation.widgets.form.colortitle;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.form.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.form.colortitle.enums.CustomFieldColorRadioEnum;

import java.time.LocalDateTime;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3026DTO extends DataResponseDTO {

    private String customField;
    @SearchParameter(name = "customFieldColorInlinePicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldColorInlinePicklist;
    @SearchParameter(name = "customFieldColorInlinePicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldColorInlinePicklistId;
    @SearchParameter(name = "customFieldColorPicklistEntity.customField", provider = StringValueProvider.class)
    private String customFieldColorPicklist;
    @SearchParameter(name = "customFieldColorPicklistEntity.id", provider = LongValueProvider.class)
    private Long customFieldColorPicklistId;
    @SearchParameter(name = "customFieldColorRadio", provider = EnumValueProvider.class)
    private CustomFieldColorRadioEnum customFieldColorRadio;
    @SearchParameter(name = "customFieldColorMoney", provider = BigDecimalValueProvider.class)
    private Double customFieldColorMoney;
    @SearchParameter(name = "customFieldColorPercent", provider = BigDecimalValueProvider.class)
    private Long customFieldColorPercent;
    @SearchParameter(name = "customFieldColorNumber", provider = BigDecimalValueProvider.class)
    private Long customFieldColorNumber;
    @SearchParameter(name = "customFieldColorFileUploade", provider = StringValueProvider.class)
    private String customFieldColorFileUploade;
    private String customFieldColorFileUploadeId;
    @SearchParameter(name = "customFieldColorDictionary", provider = EnumValueProvider.class)
    private CustomFieldColorDictionaryEnum customFieldColorDictionary;
    @SearchParameter(name = "customFieldColorDateTimeWithSeconds", provider = DateValueProvider.class)
    private LocalDateTime customFieldColorDateTimeWithSeconds;
    @SearchParameter(name = "customFieldColorDate", provider = DateValueProvider.class)
    private LocalDateTime customFieldColorDate;
    @SearchParameter(name = "customFieldColorCheckbox", provider = BooleanValueProvider.class)
    private Boolean customFieldColorCheckbox;
    @SearchParameter(name = "customFieldColorDateTime", provider = DateTimeValueProvider.class)
    private LocalDateTime customFieldColorDateTime;
    @SearchParameter(name = "customFieldColorText", provider = StringValueProvider.class)
    private String customFieldColorText;
    @SearchParameter(name = "customFieldColorInput", provider = StringValueProvider.class)
    private String customFieldColorInput;

    public MyExample3026DTO(MyEntity3026 entity) {
        this.id = entity.getId().toString();
        this.customField = entity.getCustomField();
        this.customFieldColorInlinePicklistId = Optional.ofNullable(entity.getCustomFieldColorInlinePicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldColorInlinePicklist = Optional.ofNullable(entity.getCustomFieldColorInlinePicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldColorPicklistId = Optional.ofNullable(entity.getCustomFieldColorPicklistEntity())
                .map(e -> e.getId())
                .orElse(null);
        this.customFieldColorPicklist = Optional.ofNullable(entity.getCustomFieldColorPicklistEntity())
                .map(e -> e.getCustomField())
                .orElse(null);
        this.customFieldColorRadio = entity.getCustomFieldColorRadio();
        this.customFieldColorMoney = entity.getCustomFieldColorMoney();
        this.customFieldColorPercent = entity.getCustomFieldColorPercent();
        this.customFieldColorNumber = entity.getCustomFieldColorNumber();
        this.customFieldColorFileUploade = entity.getCustomFieldColorFileUploade();
        this.customFieldColorFileUploadeId = entity.getCustomFieldColorFileUploadeId();
        this.customFieldColorDictionary = entity.getCustomFieldColorDictionary();
        this.customFieldColorDateTimeWithSeconds = entity.getCustomFieldColorDateTimeWithSeconds();
        this.customFieldColorDate = entity.getCustomFieldColorDate();
        this.customFieldColorCheckbox = entity.getCustomFieldColorCheckbox();
        this.customFieldColorDateTime = entity.getCustomFieldColorDateTime();
        this.customFieldColorText = entity.getCustomFieldColorText();
        this.customFieldColorInput = entity.getCustomFieldColorInput();
    }
}