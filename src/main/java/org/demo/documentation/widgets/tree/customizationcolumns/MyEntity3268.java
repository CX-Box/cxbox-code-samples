package org.demo.documentation.widgets.tree.customizationcolumns;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldRadioEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268InlinePick;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268Multi;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268MultiHover;
import org.demo.documentation.widgets.tree.customizationcolumns.forfields.MyEntity3268Pick;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3268 extends BaseEntity {
	@Column
	private String customField;
	@Column
	private String customFieldInput;
	@Column
	private LocalDateTime customFieldDate;
	@Column
	private Boolean customFieldCheckBox;
	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldDictionaryEnum customFieldDictionary;

	@Column
	private String customFieldHint;

	@Enumerated(value = EnumType.STRING)
	@Column
	private CustomFieldRadioEnum customFieldRadio;
	@Column
	private Double customFieldMoney;
	@JoinColumn(name = "CUSTOM_FIELD_INLINE_ID")
	@ManyToOne
	private MyEntity3268InlinePick customFieldInlineEntity;
	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private MyEntity3268Pick customFieldPickTreeEntity;
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
	private LocalDateTime customFieldDateTime;
	@Column
	private String customFieldText;
	@Column
	private String customFieldHidden;
	@JoinTable(name = "MyEntity3268_MyEntity3268Multi",
			joinColumns = @JoinColumn(name = "MyEntity3268_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3268Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3268Multi> customFieldMultivalueTree = new ArrayList<>();
	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_3268", joinColumns = @JoinColumn(name = "MyEntity3268_ID"))
	@ElementCollection(targetClass = CustomFieldMultipleSelectEnum.class)
	@Column(name = "VALUE", nullable = false)
	private Set<CustomFieldMultipleSelectEnum> customFieldMultipleSelect = new HashSet<>();
	@JoinTable(name = "MyEntity3268_MyEntity3268MultiHover",
			joinColumns = @JoinColumn(name = "MyEntity3268_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3268MultiHover_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3268MultiHover> customFieldMultivalueHoverTree = new ArrayList<>();
}