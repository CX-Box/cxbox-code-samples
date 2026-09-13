package org.demo.documentation.widgets.picktree.base.allfields.forfields.picktreepopup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.cxbox.model.core.entity.BaseEntity;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343Multi;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343MultiMulti;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343PickInlinePicktree;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.MyEntity3343PickPicktree;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picktree.base.allfields.forfields.enums.CustomFieldRadioEnum;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class MyEntity3343Pick extends BaseEntity {
	@Column
	private String customFieldPick;
	@JoinTable(name = "MyEntity3343Pick_MyEntity3343MultiMulti",
			joinColumns = @JoinColumn(name = "MyEntity3343Pick_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3343MultiMulti_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3343MultiMulti> customFieldMultivalueHoverList = new ArrayList<>();
	@JoinTable(name = "MyEntity3343Pick_MyEntity3343Multi",
			joinColumns = @JoinColumn(name = "MyEntity3343Pick_id"),
			inverseJoinColumns = @JoinColumn(name = "MyEntity3343Multi_id")
	)
	@ManyToMany(cascade =
			{CascadeType.PERSIST,
					CascadeType.MERGE})
	private List<MyEntity3343Multi> customFieldMultivalueList = new ArrayList<>();
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_INLINE_PICKLIST_ID")
	@ManyToOne
	private MyEntity3343PickInlinePicktree customFieldInlinePicktreeEntity;
	@JoinColumn(name = "CUSTOM_FIELD_COLOR_PICKLIST_ID")
	@ManyToOne
	private MyEntity3343PickPicktree customFieldPicktreeEntity;
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

	@Column
	private Long parentId;

	@OneToMany(mappedBy = "parentId", fetch = FetchType.LAZY)
	private List<MyEntity3343Pick> children = new ArrayList<>();

}
