package org.demo.documentation.widgets.tree.customizationcolumns;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.*;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldMultipleSelectEnum1;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268Multi;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268MultiHover;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MyExample3268DTO extends DataResponseDTO {

	private String customField;
	@SearchParameter(name = "customFieldInput")
	private String customFieldInput;
	@SearchParameter(name = "customFieldDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldDate;
	@SearchParameter(name = "customFieldCheckBox", provider = BooleanValueProvider.class)
	private Boolean customFieldCheckBox;
	@SearchParameter(name = "customFieldDictionary", provider = EnumValueProvider.class)
	private CustomFieldDictionaryEnum customFieldDictionary;

	private String customFieldMultivalueHoverDisplayedKey;
	private String customFieldHint;

	private String customFieldMultivalueDisplayedKey;

	@SearchParameter(name = "customFieldRadio", provider = EnumValueProvider.class)
	private CustomFieldRadioEnum customFieldRadio;
	@SearchParameter(name = "customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;
	@SearchParameter(name = "customFieldInlineEntity.customField")
	private String customFieldInline;
	@SearchParameter(name = "customFieldInlineEntity.id", provider = LongValueProvider.class)
	private Long customFieldInlineId;
	@SearchParameter(name = "customFieldPickTreeEntity.customField")
	private String customFieldPickTree;
	@SearchParameter(name = "customFieldPickTreeEntity.id", provider = LongValueProvider.class)
	private Long customFieldPickTreeId;
	@SearchParameter(name = "customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldPercent;
	@SearchParameter(name = "customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;
	@SearchParameter(name = "customFieldFileUpload")
	private String customFieldFileUpload;
	private String customFieldFileUploadId;
	@SearchParameter(name = "customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldDateTimeWithSeconds;
	@SearchParameter(name = "customFieldDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldDateTime;
	@SearchParameter(name = "customFieldText")
	private String customFieldText;
	private String customFieldHidden;
	@SearchParameter(name = "customFieldMultivalueTree.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalue;
	@SearchParameter(name = "customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@EnumValueProvider.BaseEnum(value = CustomFieldMultipleSelectEnum1.class)
	private MultivalueField customFieldMultipleSelect;
	@SearchParameter(name = "customFieldMultivalueHoverTree.id", provider = LongValueProvider.class)
	private MultivalueField customFieldMultivalueHover;

	public MyExample3268DTO(MyEntity3268 entity) {
		this.id = entity.getId().toString();
		this.customField = entity.getCustomField();
		this.customFieldInput = entity.getCustomFieldInput();
		this.customFieldDate = entity.getCustomFieldDate();
		this.customFieldCheckBox = entity.getCustomFieldCheckBox();
		this.customFieldDictionary = entity.getCustomFieldDictionary();

		this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverTree().stream().map(MyEntity3268MultiHover::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldHint = entity.getCustomFieldHint();
		this.customFieldRadio = entity.getCustomFieldRadio();
		this.customFieldMoney = entity.getCustomFieldMoney();
		this.customFieldInlineId = Optional.ofNullable(entity.getCustomFieldInlineEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldInline = Optional.ofNullable(entity.getCustomFieldInlineEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPickTreeId = Optional.ofNullable(entity.getCustomFieldPickTreeEntity())
				.map(e -> e.getId())
				.orElse(null);
		this.customFieldPickTree = Optional.ofNullable(entity.getCustomFieldPickTreeEntity())
				.map(e -> e.getCustomField())
				.orElse(null);
		this.customFieldPercent = entity.getCustomFieldPercent();
		this.customFieldNumber = entity.getCustomFieldNumber();
		this.customFieldFileUpload = entity.getCustomFieldFileUpload();
		this.customFieldFileUploadId = entity.getCustomFieldFileUploadId();
		this.customFieldDateTimeWithSeconds = entity.getCustomFieldDateTimeWithSeconds();
		this.customFieldDateTime = entity.getCustomFieldDateTime();
		this.customFieldText = entity.getCustomFieldText();
		this.customFieldHidden = entity.getCustomFieldHidden();
		this.customFieldMultivalue = entity.getCustomFieldMultivalueTree().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3268Multi::getCustomField
		));
		this.customFieldMultivalueDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueTree().stream().map(MyEntity3268Multi::getCustomField
		).collect(Collectors.joining(",")), 12);
		this.customFieldMultipleSelect = entity.getCustomFieldMultipleSelect().stream().collect(MultivalueField.toMultivalueField(Enum::name, CustomFieldMultipleSelectEnum::getValue));
		this.customFieldMultivalueHover = entity.getCustomFieldMultivalueHoverTree().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()),
				MyEntity3268MultiHover::getCustomField
		));
		this.customFieldMultivalueHoverDisplayedKey = StringUtils.abbreviate(entity.getCustomFieldMultivalueHoverTree().stream().map(MyEntity3268MultiHover::getCustomField
		).collect(Collectors.joining(",")), 12);
	}
}