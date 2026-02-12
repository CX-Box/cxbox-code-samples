package org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067Multi;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067MultiMulti;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067PickInlinePicklist;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.MyEntity3067PickPicklist;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3067Pick extends BaseEntity {
	@Column
	private String customFieldPick;
	@JoinTable(name = "MyEntity3067Pick_MyEntity3067MultiMulti",
			joinColumns = @JoinColumn(name = "MyEntity3067Pick_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3067MultiMulti_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3067MultiMulti> customFieldMultivalueHoverList = new ArrayList<>();
	@JoinTable(name = "MyEntity3067Pick_MyEntity3067Multi",
			joinColumns = @JoinColumn(name = "MyEntity3067Pick_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3067Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3067Multi> customFieldMultivalueList = new ArrayList<>();
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
	@ManyToOne
	private MyEntity3067PickInlinePicklist customFieldInlinePicklistEntity;
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
	@ManyToOne
	private MyEntity3067PickPicklist customFieldPicklistEntity;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldRadioEnum customFieldRadio;
	@Column
	private Double customFieldMoney;
	@Column
	private Long customFieldPercent;
	@Column
	private Long customFieldNumber;
	@Column
	private String customFieldFileUploade;
	@Column
	private String customFieldFileUploadeId;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;
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
	private String customFieldInput;
	@Column
	private String customField;
}