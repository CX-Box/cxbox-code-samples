package org.demo.documentation.feature.drilldown.drilldownfilter;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.cxbox.api.data.dto.DataResponseDTO;
import org.cxbox.core.dto.multivalue.MultivalueField;
import org.cxbox.core.util.filter.SearchParameter;
import org.cxbox.core.util.filter.provider.impl.BigDecimalValueProvider;
import org.cxbox.core.util.filter.provider.impl.BooleanValueProvider;
import org.cxbox.core.util.filter.provider.impl.DateTimeValueProvider;
import org.cxbox.core.util.filter.provider.impl.DateValueProvider;
import org.cxbox.core.util.filter.provider.impl.DictionaryValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider;
import org.cxbox.core.util.filter.provider.impl.EnumValueProvider.BaseEnum;
import org.cxbox.core.util.filter.provider.impl.LongValueProvider;
import org.cxbox.core.util.filter.provider.impl.MultiFieldValueProvider;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.drilldown.drilldownfilter.dictionary.CustomField4300Dictionary;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;

@Getter
@Setter
@NoArgsConstructor
public class MyExample4300WithDrilldownKeyDTO extends DataResponseDTO {

	@SearchParameter(name = "firstEntity.secondEntity.customField")
	private String customField;

	private String customFieldDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldHint")
	private String customFieldHint;

	private String customFieldHintDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldMultipleSelect", multiFieldKey = EnumValueProvider.class, provider = MultiFieldValueProvider.class)
	@BaseEnum(value = CustomField4300MultipleSelectEnum.class)
	private MultivalueField customFieldMultipleSelect;

	private String customFieldMultipleSelectDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.multivalueList.id", provider = MultiFieldValueProvider.class)
	private MultivalueField customFieldMultivalue;

	private String customFieldMultivalueDisplayKey;

	private String customFieldMultivalueDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.multivalueHoverList.id", provider = MultiFieldValueProvider.class)
	private MultivalueField customFieldMultivalueHover;

	private String customFieldMultivalueHoverDisplayKey;

	private String customFieldMultivalueHoverDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.myEntity4300PickList.value")
	private String customFieldPickList;

	@SearchParameter(name = "firstEntity.secondEntity.myEntity4300PickList.id", provider = LongValueProvider.class)
	private Long customFieldPickListId;

	private String customFieldPickListDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.myEntity4300InlinePickList.value")
	private String customFieldInlinePickList;

	@SearchParameter(name = "firstEntity.secondEntity.myEntity4300InlinePickList.id", provider = LongValueProvider.class)
	private Long customFieldInlinePickListId;

	private String customFieldInlinePickListDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.myEntity4300InlinePickList.value")
	private String customFieldSuggestionPickList;

	@SearchParameter(name = "firstEntity.secondEntity.myEntity4300InlinePickList.id", provider = LongValueProvider.class)
	private Long customFieldSuggestionPickListId;

	private String customFieldSuggestionPickListDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldRadio", provider = EnumValueProvider.class)
	private CustomField4300RadioEnum customFieldRadio;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldRadio", provider = EnumValueProvider.class)
	private CustomField4300RadioEnum customFieldRadioMultiField;

	private String customFieldRadioMultiFieldDrilldownKey;

	private String customFieldRadioDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldMoney", provider = BigDecimalValueProvider.class)
	private Double customFieldMoney;

	private String customFieldMoneyDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldPercent", provider = BigDecimalValueProvider.class)
	private Long customFieldPercent;

	private String customFieldPercentDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldNumber", provider = BigDecimalValueProvider.class)
	private Long customFieldNumber;

	private String customFieldNumberDrillDownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldFileUpload")
	private String customFieldFileUpload;

	private String customFieldFileUploadId;

	private String customFieldFileUploadDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldDictionary", provider = EnumValueProvider.class)
	private CustomField4300DictionaryEnum customFieldDictionary;

	private String customFieldDictionaryDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldDateTimeWithSeconds", provider = DateValueProvider.class)
	private LocalDateTime customFieldDateTimeWithSeconds;

	private String customFieldDateTimeWithSecondsDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldDate", provider = DateValueProvider.class)
	private LocalDateTime customFieldDate;

	private String customFieldDateDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldCheckbox", provider = BooleanValueProvider.class)
	private Boolean customFieldCheckbox;

	private String customFieldCheckboxDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldDateTime", provider = DateTimeValueProvider.class)
	private LocalDateTime customFieldDateTime;

	private String customFieldDateTimeDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldText")
	private String customFieldText;

	private String customFieldTextDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customFieldHidden")
	private String customFieldHidden;

	private String customFieldHiddenDrilldownKey;

	@SearchParameter(name = "firstEntity.secondEntity.customField4300Dictionary", provider = DictionaryValueProvider.class)
	private CustomField4300Dictionary customField4300Dictionary;
	private String customField4300DictionaryDrillDownKey;

	public MyExample4300WithDrilldownKeyDTO(MyEntity4300WithDriildownKey entity) {
		this.id = String.valueOf(entity.getId());
		this.customField = entity.getFirstEntity().getSecondEntity().getCustomField();
		this.customFieldHint = entity.getFirstEntity().getSecondEntity().getCustomFieldHint();
		this.customFieldMultipleSelect = entity.getFirstEntity().getSecondEntity().getCustomFieldMultipleSelect().stream()
				.collect(MultivalueField.toMultivalueField(Enum::name, CustomField4300MultipleSelectEnum::getValue));

		this.customFieldMultivalue = entity.getFirstEntity().getSecondEntity().getMultivalueList().stream().collect(MultivalueField.toMultivalueField(
				e -> String.valueOf(e.getId()), MyEntity4300Multivalue::getValue
		));
		this.customFieldMultivalueDisplayKey = entity.getFirstEntity().getSecondEntity().getMultivalueList().stream()
				.map(MyEntity4300Multivalue::getValue)
				.collect(Collectors.joining(","));
		this.customFieldMultivalueHover = entity.getFirstEntity().getSecondEntity().getMultivalueHoverList().stream()
				.collect(MultivalueField.toMultivalueField(
						e -> String.valueOf(e.getId()), MyEntity4300MultivalueHover::getValue
				));
		this.customFieldMultivalueHoverDisplayKey = entity.getFirstEntity().getSecondEntity().getMultivalueHoverList().stream()
				.map(MyEntity4300MultivalueHover::getValue)
				.collect(Collectors.joining(","));

		this.customFieldInlinePickList = Optional.ofNullable(entity.getFirstEntity().getSecondEntity())
				.map(MyEntity4300SecondEntity::getMyEntity4300InlinePickList)
				.map(MyEntity4300InlinePickList::getValue).orElse(null);
		this.customFieldInlinePickListId = Optional.ofNullable(entity.getFirstEntity().getSecondEntity())
				.map(MyEntity4300SecondEntity::getMyEntity4300InlinePickList)
				.map(BaseEntity::getId).orElse(null);

		this.customFieldPickList = Optional.ofNullable(entity.getFirstEntity().getSecondEntity()).map(MyEntity4300SecondEntity::getMyEntity4300PickList)
				.map(MyEntity4300PickList::getValue)
				.orElse(null);
		this.customFieldPickListId = Optional.ofNullable(entity.getFirstEntity().getSecondEntity()).map(MyEntity4300SecondEntity::getMyEntity4300PickList)
				.map(BaseEntity::getId)
				.orElse(null);

		this.customFieldSuggestionPickList = Optional.ofNullable(entity.getFirstEntity().getSecondEntity())
				.map(MyEntity4300SecondEntity::getMyEntity4300InlinePickList)
				.map(MyEntity4300InlinePickList::getValue).orElse(null);

		this.customFieldSuggestionPickListId = Optional.ofNullable(entity.getFirstEntity().getSecondEntity())
				.map(MyEntity4300SecondEntity::getMyEntity4300InlinePickList)
				.map(BaseEntity::getId).orElse(null);

		this.customFieldRadio = entity.getFirstEntity().getSecondEntity().getCustomFieldRadio();
		this.customFieldRadioMultiField = entity.getFirstEntity().getSecondEntity().getCustomFieldRadio();
		this.customFieldMoney = entity.getFirstEntity().getSecondEntity().getCustomFieldMoney();
		this.customFieldPercent = entity.getFirstEntity().getSecondEntity().getCustomFieldPercent();
		this.customFieldNumber = entity.getFirstEntity().getSecondEntity().getCustomFieldNumber();
		this.customFieldFileUpload = entity.getFirstEntity().getSecondEntity().getCustomFieldFileUpload();
		this.customFieldFileUploadId = entity.getFirstEntity().getSecondEntity().getCustomFieldFileUploadId();
		this.customFieldDictionary = entity.getFirstEntity().getSecondEntity().getCustomFieldDictionary();
		this.customFieldDateTimeWithSeconds = entity.getFirstEntity().getSecondEntity().getCustomFieldDateTimeWithSeconds();
		this.customFieldDate = entity.getFirstEntity().getSecondEntity().getCustomFieldDate();
		this.customFieldCheckbox = entity.getFirstEntity().getSecondEntity().getCustomFieldCheckbox();
		this.customFieldDateTime = entity.getFirstEntity().getSecondEntity().getCustomFieldDateTime();
		this.customFieldText = entity.getFirstEntity().getSecondEntity().getCustomFieldText();
		this.customFieldHidden = entity.getFirstEntity().getSecondEntity().getCustomFieldHidden();
		this.customField4300Dictionary = entity.getFirstEntity().getSecondEntity().getCustomField4300Dictionary();

	}

}
