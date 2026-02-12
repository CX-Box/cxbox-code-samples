package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.groupinghierarhy.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.base.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.groupinghierarhy.base.allfields.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3202 extends BaseEntity {
	@Column
	private String customField;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
	@JoinTable(name = "MyEntity3202_MyEntity3202MultiHoverPick",
			joinColumns = @JoinColumn(name = "MyEntity3202_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3202MultiHover_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3202MultiHover> customFieldMultivalueHoverList = new ArrayList<>();
	@Column
	private String customFieldHint;
	@JoinTable(name = "MyEntity3202_MyEntity3202MultiPick",
			joinColumns = @JoinColumn(name = "MyEntity3202_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3202Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3202Multi> customFieldMultivalueList = new ArrayList<>();
	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_3202", joinColumns = @JoinColumn(name = "MyEntity3202_ID"))
	@ElementCollection(targetClass = CustomFieldMultipleSelectEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<CustomFieldMultipleSelectEnum> customFieldMultipleSelect = new HashSet<>();
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldRadioEnum customFieldRadio;
	@Column
	private Double customFieldMoney;
	@JoinColumn(name = "CUSTOM_FIELD_INLINE_ID")
	@ManyToOne
	private MyEntity3202Pick customFieldInlineEntity;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3202Pick customFieldPickListEntity;
	@Column
	private Long customFieldPercent;
	@Column
	private Long customFieldNumber;
	@Column
	private String customFieldFileUpload;
	@Column
	private String customFieldFileUploadId;
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
}