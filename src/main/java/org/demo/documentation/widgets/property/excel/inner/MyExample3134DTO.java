package org.demo.documentation.widgets.property.excel.inner;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.fields.money.currency.fieldkey.enums.CustomFieldCurrencyDictionaryEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.property.excel.inner.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134Multi;
import org.demo.documentation.widgets.property.excel.inner.forfields.MyEntity3134MultiHover;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.demo.documentation.fields.money.currency.fieldkey.enums.CustomFieldCurrencyDictionaryEnum.DOLLAR;
import static org.demo.documentation.fields.money.currency.fieldkey.enums.CustomFieldCurrencyDictionaryEnum.RUBLE;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3134DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalueHover;
	private String customFieldMultivalueHoverDisplayedKey;
	private String customFieldHint;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	private String customFieldMultivalueDisplayedKey;
	@SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum.class)
	private MultivalueField customFieldMultipleSelect;
	@SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
	private CustomFieldRadioEnum customFieldRadio;
	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;
	@SearchParameter(name = "customFieldInlineEntity.customField")
	private String customFieldInline;
	@SearchParameter(name = "customFieldInlineEntity.id", provider = LongValueProvider.class)
	private Long customFieldInlineId;
	@SearchParameter(name = "customFieldPickListEntity.customField")
	private String customFieldPickList;
	@SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickListId;
	@SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldPercent;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;
	@SearchParameter(name = "customFieldFileUpload")
	private String customFieldFileUpload;
	private String customFieldFileUploadId;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;
	@SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldDateTimeWithSeconds;
	@SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldDate;
	@SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldCheckbox;
	@SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldDateTime;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;
	private String customFieldHidden;
	@SearchParameter(name = "customFieldMoneyWithCurrencyConst", provider = BigDecimalValueProvider.class)
	private Double customFieldMoneyWithCurrencyConst;
	private CustomFieldCurrencyDictionaryEnum customFieldCurrency;
	@SearchParameter(name = "customFieldMoneyWithCurrencyDynamic", provider = BigDecimalValueProvider.class)
	private Double customFieldMoneyWithCurrencyDynamic;

	@SearchParameter(name = "customFieldSuggectionPickListEntity.customField", provider = StringValueProvider.class)
	private String customFieldSuggectionPickList;

	@SearchParameter(name = "customFieldSuggectionPickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldSuggectionPickListId;

	public MyExample3134DTO(MyEntity3134 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldCurrency = entity.getCustomFieldMoney() > 50000 ? RUBLE : DOLLAR;
		this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3134MultiHover::getCustomField
		));
		this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntity3134MultiHover::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldHint = entity.getCustomFieldHint();
		this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3134Multi::getCustomField
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3134Multi::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
		this.customFieldRadio = entity.getCustomFieldRadio();
		this.customFieldMoney = entity.getCustomFieldMoney();
		this.customFieldInlineId = Optional.ofNullable(entity.getCustomFieldInlineEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldInline = Optional.ofNullable(entity.getCustomFieldInlineEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPercent = entity.getCustomFieldPercent();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldFileUpload = entity.getCustomFieldFileUpload();
		this.customFieldFileUploadId = entity.getCustomFieldFileUploadId();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
		this.customFieldDate = entity.getCustomFieldDate();
		this.customFieldCheckbox = entity.getCustomFieldCheckbox();
		this.customFieldDateTime = entity.getCustomFieldDateTime();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldHidden = entity.getCustomFieldHidden();
		this.customFieldMoneyWithCurrencyConst = entity.getCustomFieldMoneyWithCurrencyConst();
		this.customFieldMoneyWithCurrencyDynamic = entity.getCustomFieldMoneyWithCurrencyDynamic();
		this.customFieldSuggectionPickListId = Optional.ofNullable(entity.getCustomFieldSuggectionPickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldSuggectionPickList = Optional.ofNullable(entity.getCustomFieldSuggectionPickListEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
	}
}