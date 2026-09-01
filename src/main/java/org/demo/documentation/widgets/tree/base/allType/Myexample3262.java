package org.demo.documentation.widgets.tree.base.allType;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Multi;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262MultiHover;
import org.demo.documentation.widgets.tree.base.allType.entity.Myexample3262Pick;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "MYEXAMPLE3262")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = {}, callSuper = true)
public class Myexample3262 extends BaseEntity {

	@Column
	private String customFieldHint;

	@JoinTable(name = "MYEXAMPLE3262_MYEXAMPLE3262MULTIHOVERPICK_1",
			joinColumns = @JoinColumn(name = "MYEXAMPLE3262_ID"),
			inverseJoinColumns = @JoinColumn(name = "MYEXAMPLE3262MULTIHOVER_ID")
	)
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Myexample3262MultiHover> customFieldMultivalueHoverList = new ArrayList<>();

	@JoinTable(name = "MYEXAMPLE3262_MYEXAMPLE3262MULTIPICK_2",
			joinColumns = @JoinColumn(name = "MYEXAMPLE3262_ID"),
			inverseJoinColumns = @JoinColumn(name = "MYEXAMPLE3262MULTI_ID")
	)

	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<Myexample3262Multi> customFieldMultivalueList = new ArrayList<>();

	@Enumerated(value = EnumType.STRING)
	@CollectionTable(name = "CUSTOM_FIELD_MULTIPLE_SELECT_MYEXAMPLE3262_1", joinColumns = @JoinColumn(name = "Myexample3262_ID"))
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
	private Myexample3262Pick customFieldInlineEntity;

	@JoinColumn(name = "CUSTOM_FIELD_PICK_LIST_ID")
	@ManyToOne
	private Myexample3262Pick customFieldPickListEntity;

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
	private String customFieldHidden;

	@Column
	private String customField;

	@Column
	private Long parentId;
}