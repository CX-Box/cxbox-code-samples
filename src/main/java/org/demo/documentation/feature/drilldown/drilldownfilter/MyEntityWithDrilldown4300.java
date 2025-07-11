package org.demo.documentation.feature.drilldown.drilldownfilter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300DictionaryEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300MultipleSelectEnum;
import org.demo.documentation.feature.drilldown.drilldownfilter.enums.CustomField4300RadioEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
public class MyEntityWithDrilldown4300 extends BaseEntity {

	@Column
	private String customField;

	@Column
	private String customFieldHint;

	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_MY_ENTITY_WITH_DRILLDOWN4300", joinColumns = @JoinColumn(name = "MY_ENTITY_WITH_DRILLDOWN4300_ID"))
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

	@JoinTable(name = "LNK_MY_ENTITY_WITH_DRILLDOWN_4300__TO__MY_ENTITY_4300_MULTIVALUE",
			joinColumns = @JoinColumn(name = "MY_ENTITY_WITH_DRILLDOWN_4300_ID"),
			inverseJoinColumns = @JoinColumn(name = "MY_ENTITY_4300_MULTIVALUE_ID")
	)
	@ManyToMany(cascade = {CascadeType.MERGE})
	private List<MyEntity4300Multivalue> multivalueList = new ArrayList<>();

	@JoinTable(name = "LNK_MY_ENTITY_WD_4300__TO__MY_ENTITY_4300_MULTIVALUE_HOVER",
			joinColumns = @JoinColumn(name = "MY_ENTITY_WITH_DRILLDOWN_4300_ID"),
			inverseJoinColumns = @JoinColumn(name = "MY_ENTITY_4300_MULTIVALUE_HOVER_ID")
	)
	@ManyToMany(cascade = {CascadeType.MERGE})
	private List<MyEntity4300MultivalueHover> multivalueHoverList = new ArrayList<>();

	@JoinColumn(name = "MY_ENTITY_WITH_DRILLDOWN4300_PICK_LIST")
	@ManyToOne
	private MyEntity4300PickList myEntity4300PickList;

	@JoinColumn(name = "MY_ENTITY_WITH_DRILLDOWN4300_INLINE_PICK_LIST")
	@ManyToOne
	private MyEntity4300InlinePickList myEntity4300InlinePickList;

}
