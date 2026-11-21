package org.demo.documentation.feature.drilldown.drilldownfilter;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.drilldown.drilldownfilter.dictionary.CustomField4300Dictionary;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;


// 4300
// 4300
// drilldown filters

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MyEntity4300PostActionWithCustomBuilder extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customFieldHint;

	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_MYEXAMPLE_FROM_4300", joinColumns = @JoinColumn(name = "MY_ENTITY4300_POST_ACTION_WITH_CUSTOM_BUILDER_ID"))
	@ElementCollection(targetClass = CustomField4300MultipleSelectEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<CustomField4300MultipleSelectEnum> customFieldMultipleSelect = new HashSet<>();

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomField4300RadioEnum customFieldRadio;

	@Column
	private Double customFieldMoney;

	@Column
	private Long customFieldPercent;

	@Column
	private Long customFieldNumber;

	@Column
	private String customFieldFileUpload;

	@Column
	private String customFieldFileUploadId;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomField4300DictionaryEnum customFieldDictionary;

	@Column
	private LocalDateTime customFieldDateTimeWithSeconds;

	@Column
	private LocalDateTime customFieldDate;

	@Column
	private Boolean customFieldCheckbox;

	@Column
	private LocalDateTime customFieldDateTime;

	@Column
	private String customFieldText;

	@Column
	private String customFieldHidden;

	@JoinTable(name = "LNK_MY_ENTITY4300_POST_ACTION_WITH_CUSTOM_BUILDER__TO__MY_ENTITY_4300_MULTIVALUE",
			joinColumns = @JoinColumn(name = "MY_ENTITY4300_POST_ACTION_WITH_CUSTOM_BUILDER_ID"),
			inverseJoinColumns = @JoinColumn(name = "MY_ENTITY_4300_MULTIVALUE_ID")
	)
	@ManyToMany(cascade = {CascadeType.MERGE})
	private List<MyEntity4300Multivalue> multivalueList = new ArrayList<>();

	@JoinTable(name = "MY_ENTITY4300_P_A_W_C_B__TO__MY_ENTITY_4300_MULTIVALUE_HOVER",
			joinColumns = @JoinColumn(name = "MY_ENTITY4300_POST_ACTION_WITH_CUSTOM_BUILDER_ID"),
			inverseJoinColumns = @JoinColumn(name = "MY_ENTITY_4300_MULTIVALUE_HOVER_ID")
	)
	@ManyToMany(cascade = {CascadeType.MERGE})
	private List<MyEntity4300MultivalueHover> multivalueHoverList = new ArrayList<>();

	@JoinColumn(name = "MY_ENTITY4300_POST_ACTION_WITH_CUSTOM_BUILDER_PICK_LIST")
	@ManyToOne
	private MyEntity4300PickList myEntity4300PickList;

	@JoinColumn(name = "MY_ENTITY4300_POST_ACTION_WITH_CUSTOM_BUILDER_INLINE_PICK_LIST")
	@ManyToOne
	private MyEntity4300InlinePickList myEntity4300InlinePickList;

	@Default
	@ElementCollection
	@CollectionTable(name = "FILTER_4300_DICTIONARYVALUES", joinColumns = @JoinColumn(name = "FORM_ID"))
	@Column(name = "VALUE", nullable = false)
	private Set<CustomField4300Dictionary> dictionaryValues = new HashSet<>();

	@Default
	@ElementCollection
	@CollectionTable(name = "FILTER_4300_DICTIONARYENUMVALUES", joinColumns = @JoinColumn(name = "FORM_ID"))
	@Column(name = "VALUE", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<CustomField4300DictionaryEnum> dictionaryEnumValues = new HashSet<>();

	@Default
	@ElementCollection
	@CollectionTable(name = "FILTER_4300_RADIOVALUES", joinColumns = @JoinColumn(name = "FORM_ID"))
	@Column(name = "VALUE", nullable = false)
	@Enumerated(EnumType.STRING)
	private Set<CustomField4300RadioEnum> radioValues = new HashSet<>();

	@Column(name = "CUSTOM_FIELD_NUMBER_TO")
	private Long customFieldNumberTo;

	@Column(name = "CUSTOM_FIELD_MONEY_TO")
	private Double customFieldMoneyTo;

	@Column(name = "CUSTOM_FIELD_PERCENT_TO")
	private Long customFieldPercentTo;

	@Column(name = "CUSTOM_FIELD_DATE_TO")
	private LocalDateTime customFieldDateTo;

	@Column(name = "CUSTOM_FIELD_DATE_TIME_TO")
	private LocalDateTime customFieldDateTimeTo;

	@Column(name = "CUSTOM_FIELD_DATE_TIME_WITH_SECONDS_TO")
	private LocalDateTime customFieldDateTimeWithSecondsTo;

	@Column(name = "DICTIONARY_VALUE")
	private CustomField4300Dictionary dictionaryValue;

	@Column(name = "CUSTOM_FIELD_MULTIFIELD")
	private String customFieldMultifield;

	@Column(name = "EXPANDED_COLUMNS")
	private boolean expandedColumns;
	@Column(name = "RANGE_FILTERS")
	private boolean rangeFilters;

}
