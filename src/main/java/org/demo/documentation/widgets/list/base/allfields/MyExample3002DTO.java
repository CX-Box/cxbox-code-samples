package org.demo.documentation.widgets.list.base.allfields;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.list.base.allfields.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Multi;
import org.demo.documentation.widgets.list.base.allfields.forfields.MyEntity3002Multi2;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;


@Getter
@Setter
@NoArgsConstructor
public class MyExample3002DTO extends DataResponseDTO {

	public static final String INFO_TEXT = "List widget is list the general information for many records and present it in a way that is easily interpretable for users.";

	@SearchParameter(name = "customField")
	private String customField;
	private String customFieldHidden;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;
	@SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldDateTime;
	@SearchParameter(name = "customFieldCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldCheckbox;
	@SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldDate;
	@SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldDateTimeWithSeconds;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;
	@SearchParameter(name = "customFieldFileUpload")
	private String customFieldFileUpload;
	private String customFieldFileUploadId;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;
	@SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldPercent;
	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;
	@SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
	private CustomFieldRadioEnum customFieldRadio;
	@SearchParameter(name = "customFieldPickListEntity.customField")
	private String customFieldPickList;
	@SearchParameter(name = "customFieldPickListEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickListId;
	@SearchParameter(name = "customFieldInlineEntity.customField")
	private String customFieldInline;
	@SearchParameter(name = "customFieldInlineEntity.id", provider = LongValueProvider.class)
	private Long customFieldInlineId;
	@SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum.class)
	private MultivalueField customFieldMultipleSelect;
	@SearchParameter(name = "customFieldMultivalueList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	private String customFieldMultivalueDisplayedKey;
	private String customFieldHint;
	@SearchParameter(name = "customFieldMultivalueHoverList.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalueHover;
	private String customFieldMultivalueHoverDisplayedKey;

	public MyExample3002DTO(MyEntity3002 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldHidden = entity.getCustomFieldHidden();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldDateTime = entity.getCustomFieldDateTime();
		this.customFieldCheckbox = entity.getCustomFieldCheckbox();
		this.customFieldDate = entity.getCustomFieldDate();
		this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
		this.customFieldDictionary = entity.getCustomFieldDictionary();
		this.customFieldFileUpload = entity.getCustomFieldFileUpload();
		this.customFieldFileUploadId = entity.getCustomFieldFileUploadId();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldPercent = entity.getCustomFieldPercent();
		this.customFieldMoney = entity.getCustomFieldMoney();
		this.customFieldRadio = entity.getCustomFieldRadio();
		this.customFieldPickListId = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickList = Optional.ofNullable(entity.getCustomFieldPickListEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldInlineId = Optional.ofNullable(entity.getCustomFieldInlineEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldInline = Optional.ofNullable(entity.getCustomFieldInlineEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
		this.customFieldMultivalue = entity.getCustomFieldMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3002Multi2::getCustomField
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueList().stream().map(MyEntity3002Multi2::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldHint = entity.getCustomFieldHint();
		this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3002Multi::getCustomField
		));
		this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverList().stream().map(MyEntity3002Multi::getCustomField
		).collect(Collectors.joining(",")), 12);
	}

}